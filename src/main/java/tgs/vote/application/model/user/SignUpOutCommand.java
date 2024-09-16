package tgs.vote.application.model.user;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Builder(access = AccessLevel.PRIVATE)
@Getter
public record SignUpOutCommand (
    String authorizationCode){

    public static SignUpOutCommand of(String authorizationCode){
        return SignUpOutCommand.builder()
                .authorizationCode(authorizationCode)
                .build();
    }
}
