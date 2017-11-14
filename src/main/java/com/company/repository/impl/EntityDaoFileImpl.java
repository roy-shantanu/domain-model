package com.company.repository.impl;

import com.company.domain.*;
import com.company.repository.GenericEntityDao;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * User: Shantanu Roy
 * Date: 13-Nov-17
 * Time: 10:39 PM
 */
public class EntityDaoFileImpl<E extends BaseEntity> extends BaseDaoFileImpl implements GenericEntityDao<E> {

    private Set<E> entities;
    private File file;

    public EntityDaoFileImpl(Class clazz) throws IOException {

        if (clazz == User.class) {
            this.file = entityFile("User", "users");
        } else if (clazz == Idea.class) {
            this.file = entityFile("Idea", "ideas");
        } else if (clazz == Comment.class) {
            this.file = entityFile("Comment", "comments");
        } else if (clazz == Vote.class) {
            this.file = entityFile("Vote", "votes");
        }

    }

    @Override
    public Long create(E entity) {
        this.entities = getAll();
        entity.setId(getNewId(entities));
        this.entities.add(entity);

        try {
            writeObjectToFile(entities, file);
            return entity.getId();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(E entityAfter) {
        E entityBefore = getById(entityAfter.getId());
        //allUsers null check probably not required because if userBefore != null, getAll definitely != null
        if (entityBefore != null) {
            this.entities = getAll();
            this.entities.remove(entityBefore);
            this.entities.add(entityAfter);
            try {
                writeObjectToFile(this.entities, file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //TODO:: Will it be better if I use an else if block here to throw an custom exception "UserNotFoundException" or should I use it in getById
    }

    @SuppressWarnings("unchecked")
    @Override
    public Set<E> getAll() {
        try {
            Set<E> savedEntities = (Set<E>) readObject(file);
            if (savedEntities != null) {
                return savedEntities;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new HashSet<>();
    }

    @Override
    public E getById(Long id) {
        return getAll().stream()
                .filter(entity -> Objects.equals(entity.getId(), id))
                .findFirst()
                .orElse(null);
        //TODO:: test this part with returning null value
    }

    @Override
    public void delete(E entity) {
        E entityToBeNuked = getById(entity.getId());
        if (entityToBeNuked != null) {
            this.entities = getAll();
            this.entities.remove(entityToBeNuked);
            try {
                writeObjectToFile(this.entities, file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}