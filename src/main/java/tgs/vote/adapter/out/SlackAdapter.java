package tgs.vote.adapter.out;

import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tgs.vote.adapter.model.user.SlackMember;
import tgs.vote.adapter.model.user.SlackOauth2Request;
import tgs.vote.adapter.model.user.SlackOauth2Response;
import tgs.vote.adapter.model.user.SlackUserResponse;
import tgs.vote.adapter.out.config.SlackConfig;
import tgs.vote.adapter.out.external.SlackClient;
import tgs.vote.application.model.user.LoginInResult;
import tgs.vote.application.model.user.LoginOutCommand;
import tgs.vote.application.out.UserOAuth2Port;

@Service
@RequiredArgsConstructor
public class SlackAdapter implements UserOAuth2Port {

    private final SlackConfig slackConfig;
    private final SlackClient slackClient;

    public List<SlackMember> getSlackUserList() {
        SlackUserResponse response = slackClient.getUserInfo(slackConfig.getSlackToken());
        if (response.ok()) {
            return response.members();
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public LoginInResult login(LoginOutCommand loginOutCommand) {
        SlackOauth2Request request =
                SlackOauth2Request.builder()
                        .clientId(slackConfig.getClientId())
                        .clientSecret(slackConfig.getClientSecret())
                        .redirectUri(slackConfig.getRedirectUri())
                        .code(loginOutCommand.getAuthorizationCode())
                        .build();

        SlackOauth2Response oauth2Response = slackClient.oauthV2Access(request);

        if (oauth2Response.ok()) {
            return LoginInResult.builder().providerId(oauth2Response.authedUser().id()).build();
        } else {
            throw new RuntimeException("Failed to retrieve user info from Slack");
        }
    }
}
