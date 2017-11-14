package com.company.service;

import com.company.domain.Idea;
import com.company.domain.User;

/**
 * User: Shantanu Roy
 * Date: 29-Oct-17
 * Time: 11:10 PM
 */
public interface IdeaService {

    Long postIdea(User ideaSubmitter, String ideaTitle, String ideaDescription);
    void updateIdea(Long ideaId, String ideaTitle, String ideaDescription);
    void deleteIdea(Long ideaId);
    Idea getIdeaInfo(Long ideaId);


//    public void voteOnIdea(Long ideaId);
//
//    public void voteOnComment(Long commentId);
//
//    public void postComment(Long ideaId, String commentText);
//
//    public void postReply(Long commentId, String replyText);
//
}