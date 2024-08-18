package tgs.vote.application.model.user;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LoginOutResult {

    private Long userId;
    private boolean isSuccess;
}
