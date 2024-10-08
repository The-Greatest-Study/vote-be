package tgs.vote.application.in;

import tgs.vote.application.model.user.CreateUserOutCommand;
import tgs.vote.domain.user.User;

public interface CreateUserUseCase {
    User createUser(CreateUserOutCommand user);
}
