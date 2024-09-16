package tgs.vote.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import tgs.vote.application.in.CreateUserUseCase;
import tgs.vote.application.in.GetUserUseCase;
import tgs.vote.application.in.SlackUserUseCase;
import tgs.vote.application.model.user.*;
import tgs.vote.application.out.UserOAuth2Port;
import tgs.vote.domain.user.User;

@RequiredArgsConstructor
@Log4j2
@Service
public class SlackUserService implements SlackUserUseCase {
    private final GetUserUseCase getUserUseCase;
    private final CreateUserUseCase createUserUseCase;
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
            return LoginOutResult.ofSuccess(user.getUserId());
        } else {
            return LoginOutResult.ofFalse();
        }
    }

    @Override
    public SignUpOutResult signUp(SignUpInCommand command) {
        SignUpInResult signUpResult =
                userOAuth2Port.signUp(SignUpOutCommand.of(command.getAuthorizationCode()));

        if (this.isUserExist(signUpResult.getUserId())) {
            log.debug("User already exists");
            return SignUpOutResult.ofFalse();
        } else {
            createUserUseCase.createUser(CreateUserOutCommand.of(signUpResult));
            return SignUpOutResult.ofSuccess(signUpResult);
        }
    }

    private boolean isUserExist(String providerId) {
        return getUserUseCase.findByProviderId(providerId) != null;
    }
}
