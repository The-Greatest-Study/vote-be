package tgs.vote.application.model.user;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LoginOutResult {

    private Long userId;
    private boolean isSuccess;

    public static LoginOutResult ofFalse(){
        return LoginOutResult.builder().isSuccess(false).build();
    }

    public static LoginOutResult ofSuccess(Long userId){
        return LoginOutResult.builder().userId(userId).isSuccess(true).build();
    }
}
