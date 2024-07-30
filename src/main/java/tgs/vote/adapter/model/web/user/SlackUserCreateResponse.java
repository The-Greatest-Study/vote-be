package tgs.vote.adapter.model.web.user;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Builder(access = AccessLevel.PRIVATE)
@Getter
public class SlackUserCreateResponse {
    private Long userId;

    public static SlackUserCreateResponse from(Long userId) {
        return SlackUserCreateResponse.builder().userId(userId).build();
    }
}
