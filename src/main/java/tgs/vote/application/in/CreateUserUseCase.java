package tgs.vote.application.in;

import tgs.vote.adapter.model.web.user.SlackUserCreateRequest;
import tgs.vote.application.model.user.CreateUserInCommand;
import tgs.vote.application.model.vote.CreateVoteInCommand;

public interface CreateUserUseCase {
    Long registerUserWithSlack(CreateUserInCommand command);
}
