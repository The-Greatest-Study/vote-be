package tgs.vote.application.out;

import tgs.vote.application.model.user.LoginInResult;
import tgs.vote.application.model.user.LoginOutCommand;

public interface UserOAuth2Port {
    LoginInResult login(LoginOutCommand command);
}
