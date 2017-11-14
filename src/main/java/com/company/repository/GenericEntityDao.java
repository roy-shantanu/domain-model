package com.company.repository;

import com.company.domain.BaseEntity;

import java.util.Set;

/**
 * User: Shantanu Roy
 * Date: 30-Oct-17
 * Time: 11:03 PM
 */
public interface GenericEntityDao<E extends BaseEntity> {

    Long create(E t);

    void update(E t);

    Set<E> getAll();

    E getById(Long id);

    void delete(E t);
}