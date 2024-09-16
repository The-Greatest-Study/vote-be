package tgs.vote.application.model.user;

import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public class CreateUserOutCommand {
    private Long userId;
    private String providerId;
    private String teamId;
    private String name;
    private String email;
    private String image;

    public static CreateUserOutCommand of(SignUpInResult signUpInResult){
        return CreateUserOutCommand.builder()
                .providerId(signUpInResult.getUserId())
                .teamId(signUpInResult.getTeamId())
                .name(signUpInResult.getUserName())
                .email(signUpInResult.getEmail())
                .image(signUpInResult.getProfileImageUrl())
                .build();
    }
}
