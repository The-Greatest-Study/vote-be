package tgs.vote.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tgs.vote.application.in.GetUserUseCase;
import tgs.vote.application.in.LoginUseCase;
import tgs.vote.application.model.user.*;
import tgs.vote.application.out.UserOAuth2Port;
import tgs.vote.domain.user.User;

@RequiredArgsConstructor
@Service
public class LoginService implements LoginUseCase {
    private final GetUserUseCase getUserUseCase;
    private final UserOAuth2Port userOAuth2Port;

    @Override
    public LoginOutResult login(LoginInCommand command) {
        LoginInResult loginResult =
                userOAuth2Port.login(
                        LoginOutCommand.builder()
                                .authorizationCode(command.getAuthorizationCode())
                                .build());

        User user = getUserUseCase.findByProviderId(loginResult.getProviderId());

        if (user != null) {
            return LoginOutResult.builder().userId(user.getUserId()).isSuccess(true).build();
        } else {
            return LoginOutResult.builder().isSuccess(false).build();
        }
    }
}
