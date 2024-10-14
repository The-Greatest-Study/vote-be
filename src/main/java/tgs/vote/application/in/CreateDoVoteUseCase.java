package tgs.vote.application.in;

import tgs.vote.application.model.vote.CreateDoVoteInCommand;


public interface CreateDoVoteUseCase {
    Long createDoVote(CreateDoVoteInCommand command);
}
