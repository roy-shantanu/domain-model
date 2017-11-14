package com.company.domain;

import java.util.ArrayList;
import java.util.List;

public abstract class TextContribution extends Contribution {

    private static final long serialVersionUID = -272038604770182346L;
    private List<Vote> votes = new ArrayList<>();

    public TextContribution(User user) {
        super(user);
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public void voteUp(Long voteId) {
        votes.add(new Vote(this.getUser(), voteId, this, true));
    }

    public void voteDown(Long voteId) {
        votes.add(new Vote(this.getUser(), voteId, this, false));
    }

//    public Long getNetVotes(){
//        Long upVote = votes.stream().filter(Vote::isUpVote).count();
//        Long downVote = votes.stream().filter(vote -> !vote.isUpVote()).count();
//        return upVote-downVote;
//    }
}