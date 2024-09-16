package tgs.vote.application.model.user;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Builder(access = AccessLevel.PRIVATE)
@Getter
public class SignUpOutResult {

    private boolean success;
    private String accessToken;
    private int expiresIn;
    private String tokenType;
    private String userId;
    private String teamId;
    private String userName;
    private String email;
    private String profileImageUrl;

    public static SignUpOutResult ofFalse(){
        return SignUpOutResult.builder()
                .success(false)
                .build();
    }

    public static SignUpOutResult ofSuccess(SignUpInResult signUpResult){
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
