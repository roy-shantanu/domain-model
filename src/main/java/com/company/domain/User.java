package com.company.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * User: Shantanu Roy
 * Date: 26-Oct-17
 * Time: 8:43 PM
 */
public class User extends BaseEntity {

    private static final long serialVersionUID = 7253973447094062115L;
    private Long id;
    private String fullName;
    private String userName;
    private String email;
    private Set<Contribution> contributions;

    public User(String fullName, String userName, String email) {
        this(fullName, userName, email, new HashSet<>());
    }

    public User(String fullName, String userName, String email, Set<Contribution> contributions) {
        this.fullName = fullName;
        this.userName = userName;
        this.email = email;
        this.contributions = contributions;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long userId) {
        this.id = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Contribution> getContributions() {
        return this.contributions;
    }

    public void setContributions(Set<Contribution> contributions){this.contributions = contributions;}


    public void addContributions(Contribution contribution) {
        this.contributions.add(contribution);
    }

    public void removeContributions(Contribution contribution){this.contributions.remove(contribution);}

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof User)) {
            return false;
        }

        User user = (User) o;

        return Objects.equals(user.getId(), id) &&
                user.getFullName().equals(this.fullName) &&
                user.getUserName().equals(this.userName) &&
                user.getEmail().equals(this.email);

    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + id.hashCode();
        result = 31 * result + fullName.hashCode();
        result = 31 * result + userName.hashCode();
        result = 31 * result + email.hashCode();
        return result;
    }

}