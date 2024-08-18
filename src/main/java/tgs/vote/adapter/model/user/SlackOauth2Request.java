package tgs.vote.adapter.model.user;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SlackOauth2Request {
    private final String clientId;
    private final String clientSecret;
    private final String redirectUri;
    private final String code;
}
