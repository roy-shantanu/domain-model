package com.company.service.impl;

import com.company.domain.Idea;
import com.company.domain.User;
import com.company.repository.GenericEntityDao;
import com.company.repository.impl.EntityDaoFileImpl;
import com.company.service.IdeaService;

import java.io.IOException;

/**
 * User: Shantanu Roy
 * Date: 29-Oct-17
 * Time: 11:08 PM
 */
public class IdeaServiceImpl implements IdeaService {

    private GenericEntityDao<Idea> ideaEntityDao = new EntityDaoFileImpl<>(Idea.class);

    public IdeaServiceImpl() throws IOException {
    }


    @Override
    public Long postIdea(User ideaSubmitter, String ideaTitle, String ideaDescription) {
        return ideaEntityDao.create(new Idea(ideaSubmitter, ideaTitle, ideaDescription));
    }

    @Override
    public void updateIdea(Long ideaId, String ideaTitle, String ideaDescription) {
        Idea idea = ideaEntityDao.getById(ideaId);
        idea.setIdeaTitle(ideaTitle);
        idea.setIdeaDescription(ideaDescription);
        ideaEntityDao.update(idea);
    }

    @Override
    public void deleteIdea(Long ideaId) {
        ideaEntityDao.delete(ideaEntityDao.getById(ideaId));
    }

    @Override
    public Idea getIdeaInfo(Long ideaId) {
        return ideaEntityDao.getById(ideaId);
    }
}