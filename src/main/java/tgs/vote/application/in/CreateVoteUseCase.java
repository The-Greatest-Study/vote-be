package tgs.vote.application.in;

import tgs.vote.application.model.vote.CreateVoteInCommand;

public interface CreateVoteUseCase {
    Long createVote(CreateVoteInCommand command);
}
