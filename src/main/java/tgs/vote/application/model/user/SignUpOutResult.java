package tgs.vote.application.model.user;

import lombok.Builder;
import lombok.Getter;

@Builder
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

}
