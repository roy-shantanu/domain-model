package com.company.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * User: Shantanu Roy
 * Date: 26-Oct-17
 * Time: 9:14 PM
 */
public class Comment extends TextContribution {

    private static final long serialVersionUID = 2394944892786406431L;
    private Long id;
    private Idea parentIdea;
    private Comment replyOf;
    private String commentText;
    private Set<Comment> replies;


    public Comment(User commenter, Long commentId, Idea parentIdea, String commentText, Comment replyOf) {
        this(commenter, commentId, parentIdea, commentText, replyOf, new HashSet<>());
    }

    public Comment(User commenter, Long commentId, Idea parentIdea, String commentText, Comment replyOf, Set<Comment> replies) {
        super(commenter);
        this.id = commentId;
        this.parentIdea = parentIdea;
        this.replyOf = replyOf;
        this.commentText = commentText;
        this.replies = replies;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long commentId) {
        this.id = commentId;
    }

    public Idea getParentIdea() {
        return parentIdea;
    }

    public void setParentIdea(Idea parentIdea) {
        this.parentIdea = parentIdea;
    }

    public Comment getReplyOf() {
        return replyOf;
    }

    public void setReplyOf(Comment replyOf) {
        this.replyOf = replyOf;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Set<Comment> getReplies() {
        return replies;
    }

    public void setReplies(Set<Comment> replies){this.replies = replies;}

    public void addReply(Comment reply) {
        this.replies.add(reply);
    }

    public void removeReply(Comment reply) {
        this.replies.remove(reply);
    }


    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Comment)) {
            return false;
        }

        Comment comment = (Comment) o;

        return Objects.equals(comment.getId(), this.id) &&
                comment.getParentIdea().equals(this.parentIdea) &&
                comment.getCommentText().equals(this.commentText);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + id.hashCode();
        result = 31 * result + parentIdea.hashCode();
        result = 31 * result + commentText.hashCode();
        return result;
    }
}