package tgs.vote.adapter.out;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import tgs.vote.adapter.model.user.*;
import tgs.vote.adapter.out.config.SlackConfig;
import tgs.vote.adapter.out.external.SlackClient;
import tgs.vote.application.model.user.LoginInResult;
import tgs.vote.application.model.user.LoginOutCommand;
import tgs.vote.application.model.user.SignUpInResult;
import tgs.vote.application.model.user.SignUpOutCommand;
import tgs.vote.application.out.UserOAuth2Port;

@Service
@RequiredArgsConstructor
public class SlackAdapter implements UserOAuth2Port {

    private final SlackConfig slackConfig;
    private final SlackClient slackClient;

    public List<SlackMember> getSlackUserList() {
        SlackUserListResponse response = slackClient.getUserInfo(slackConfig.getSlackToken());
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

    @Override
    public SignUpInResult signUp(SignUpOutCommand build) {
        try {
            String accessToken = getSlackAccessToken(build.getAuthorizationCode());
            SlackMember slackMember = getSlackUserInfo(accessToken);

            return SignUpInResult.builder()
                    .userId(slackMember.id())
                    .userName(slackMember.name())
                    .email(slackMember.email())
                    .profileImageUrl(slackMember.profile().image192())
                    .accessToken(accessToken)
                    .expiresIn(0)
                    .build();
        } catch (Exception e) {
            throw new RuntimeException("Failed to sign up with Slack");
        }
    }

    private String getSlackAccessToken(String authorizationCode) throws Exception {
        String tokenEndpoint = "https://slack.com/api/oauth.v2.access";
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("code", authorizationCode);
        body.add("client_id", slackConfig.getClientId());
        body.add("client_secret", slackConfig.getClientSecret());
        body.add("redirect_uri", slackConfig.getRedirectUri());

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(body, headers);

        ResponseEntity<SlackTokenResponse> response = restTemplate.exchange(
                tokenEndpoint,
                HttpMethod.POST,
                requestEntity,
                SlackTokenResponse.class
        );

        if (!Objects.requireNonNull(response.getBody()).isOk()) {
            throw new Exception("Failed to obtain Slack access token");
        }

        return response.getBody().getAccessToken();
    }

    private SlackMember getSlackUserInfo(String accessToken) throws Exception {
        String userInfoEndpoint = "https://slack.com/api/users.identity";
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<SlackUserResponse> response = restTemplate.exchange(
                userInfoEndpoint,
                HttpMethod.GET,
                requestEntity,
                SlackUserResponse.class
        );

        if (!Objects.requireNonNull(response.getBody()).ok()) {
            throw new Exception("Failed to obtain Slack user info");
        }

        return response.getBody().user();
    }

}
