package tgs.vote.application.out;

import tgs.vote.application.model.user.LoginInResult;
import tgs.vote.application.model.user.LoginOutCommand;
import tgs.vote.application.model.user.SignUpInResult;
import tgs.vote.application.model.user.SignUpOutCommand;

public interface UserOAuth2Port {
    LoginInResult login(LoginOutCommand command);

    SignUpInResult signUp(SignUpOutCommand build);
}
