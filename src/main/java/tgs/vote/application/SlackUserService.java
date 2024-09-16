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
            return LoginOutResult.builder().userId(user.getUserId()).isSuccess(true).build();
        } else {
            return LoginOutResult.builder().isSuccess(false).build();
        }
    }

    private boolean isUserExist(String providerId) {
        return getUserUseCase.findByProviderId(providerId) != null;
    }

    @Override
    public SignUpOutResult signUp(SignUpInCommand build) {
        SignUpInResult signUpResult =
                userOAuth2Port.signUp(
                        SignUpOutCommand.builder()
                                .authorizationCode(build.getAuthorizationCode())
                                .build());

        if (this.isUserExist(signUpResult.getUserId())) {
            log.debug("User already exists");
           return SignUpOutResult.builder()
                   .success(false)
                   .build();
        } else {
            createUserUseCase.createUser(
                    CreateUserOutCommand.builder()
                            .providerId(signUpResult.getUserId())
                            .teamId(signUpResult.getTeamId())
                            .name(signUpResult.getUserName())
                            .email(signUpResult.getEmail())
                            .image(signUpResult.getProfileImageUrl())
                            .build()
            );

            return SignUpOutResult.builder()
                    .success(true)
                    .userId(signUpResult.getUserId())
                    .userName(signUpResult.getUserName())
                    .email(signUpResult.getEmail())
                    .profileImageUrl(signUpResult.getProfileImageUrl())
                    .accessToken(signUpResult.getAccessToken())
                    .expiresIn(signUpResult.getExpiresIn())
                    .build();
        }
        

    }
}
