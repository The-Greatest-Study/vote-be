package tgs.vote.application.in;

import tgs.vote.application.model.user.LoginInCommand;
import tgs.vote.application.model.user.LoginOutResult;
import tgs.vote.application.model.user.SignUpInCommand;
import tgs.vote.application.model.user.SignUpOutResult;

public interface SlackUserUseCase {
    LoginOutResult login(LoginInCommand command);

    SignUpOutResult signUp(SignUpInCommand build);
}
