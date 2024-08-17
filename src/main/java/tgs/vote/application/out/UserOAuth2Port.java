package tgs.vote.application.out;

import tgs.vote.domain.user.User;

public interface UserOAuth2Port {
    User getUserInfo(String authorizationCode);
}
