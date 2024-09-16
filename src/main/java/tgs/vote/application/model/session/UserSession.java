package tgs.vote.application.model.session;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Builder(access = AccessLevel.PRIVATE)
@Getter
public class UserSession {
    private long userId;

    public static UserSession getDefault() {
        return UserSession.builder().userId(1L).build();
    }
}
