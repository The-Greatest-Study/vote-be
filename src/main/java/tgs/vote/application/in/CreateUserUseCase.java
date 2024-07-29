package tgs.vote.application.in;

import tgs.vote.application.model.vote.CreateVoteInCommand;

public interface CreateUserUseCase {
    Long createVote(CreateVoteInCommand command);
}
