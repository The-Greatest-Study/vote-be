package tgs.vote.application.model.user;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LoginInCommand {
    private String authorizationCode;
}
