package com.company.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Idea extends TextContribution {

    private static final long serialVersionUID = -5163248302893025060L;
    private Long id;
    private String ideaTitle;
    private String ideaDescription;
    private Set<Comment> comments;

    public Idea(User ideaContributor, String ideaTitle, String ideaDescription) {
        this(ideaContributor, ideaTitle, ideaDescription, new HashSet<>());
    }

    public Idea(User ideaContributor, String ideaTitle, String ideaDescription, Set<Comment> comments) {
        super(ideaContributor);
        this.ideaTitle = ideaTitle;
        this.ideaDescription = ideaDescription;
        this.comments = comments;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long ideaId) {
        this.id = ideaId;
    }

    public String getIdeaTitle() {
        return ideaTitle;
    }

    public void setIdeaTitle(String ideaTitle) {
        this.ideaTitle = ideaTitle;
    }

    public String getIdeaDescription() {
        return ideaDescription;
    }

    public void setIdeaDescription(String ideaDescription) {
        this.ideaDescription = ideaDescription;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<Comment> getComments() {
        return comments;
    }


    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public void removeComment(Comment comment) {
        this.comments.remove(comment);
    }


    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Idea)) {
            return false;
        }

        Idea idea = (Idea) o;

        return Objects.equals(idea.getId(), this.id) &&
                idea.getIdeaTitle().equals(this.ideaTitle) &&
                idea.getIdeaDescription().equals(this.ideaDescription);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + id.hashCode();
        result = 31 * result + ideaTitle.hashCode();
        result = 31 * result + ideaDescription.hashCode();
        return result;
    }
}