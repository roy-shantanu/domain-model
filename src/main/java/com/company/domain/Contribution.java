package com.company.domain;

public abstract class Contribution extends BaseEntity {

    private static final long serialVersionUID = -3507339722743065342L;
    private User user;

    public Contribution(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}