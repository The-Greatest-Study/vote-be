package tgs.vote.application.in;

import tgs.vote.adapter.in.model.VoteCreateRequest;

public interface CreateVoteUseCase {
    Long createVote(VoteCreateRequest voteCreateRequest);
}
