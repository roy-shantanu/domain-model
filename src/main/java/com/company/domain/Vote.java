package com.company.domain;

import java.util.Objects;

public class Vote extends Contribution {

    private static final long serialVersionUID = 2112658837257096846L;
    private Long id;
    private TextContribution textContribution;
    private Boolean isUpVote;

    public Vote(User voter, Long voteId, TextContribution textContribution, Boolean isUpVote) {
        super(voter);
        this.id = voteId;
        this.textContribution = textContribution;
        this.isUpVote = isUpVote;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long voteId) {
        this.id = voteId;
    }

    public TextContribution getTextContribution() {
        return textContribution;
    }

    public void setTextContribution(TextContribution textContribution) {
        this.textContribution = textContribution;
    }

    public boolean getIsUpVote() {
        return this.isUpVote;
    }

    public void setIsUpVote(Boolean isUpVote){this.isUpVote = isUpVote;}


    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Vote)) {
            return false;
        }

        Vote vote = (Vote) o;

        return Objects.equals(vote.getId(), this.id) &&
                (vote.getIsUpVote() == this.isUpVote) &&
                vote.getTextContribution().equals(this.textContribution);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + id.hashCode();
        result = 31 * result + isUpVote.hashCode();
        result = 31 * result + textContribution.hashCode();
        return result;
    }
}