package tgs.vote.adapter.model.web.user;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Builder(access = AccessLevel.PRIVATE)
@Getter
public class UserCreateResponse {
    private Long userId;

    public static UserCreateResponse from(Long userId) {
        return UserCreateResponse.builder().userId(userId).build();
    }
}
