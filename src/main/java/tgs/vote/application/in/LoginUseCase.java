package tgs.vote.application.in;

import tgs.vote.application.model.user.LoginInCommand;
import tgs.vote.application.model.user.LoginOutResult;

public interface LoginUseCase {
    LoginOutResult login(LoginInCommand command);
}
