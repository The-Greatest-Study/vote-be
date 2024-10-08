package tgs.vote.application.model.user;

import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record SignUpOutCommand(String authorizationCode) {

    public static SignUpOutCommand of(String authorizationCode) {
        return SignUpOutCommand.builder().authorizationCode(authorizationCode).build();
    }
}
