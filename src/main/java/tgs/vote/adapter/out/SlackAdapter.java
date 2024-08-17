package tgs.vote.adapter.out;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tgs.vote.adapter.model.persistence.user.SlackMember;
import tgs.vote.adapter.out.config.SlackConfig;
import tgs.vote.adapter.model.persistence.user.SlackUserResponse;
import tgs.vote.adapter.out.external.SlackClient;
import tgs.vote.application.out.UserOAuth2Port;
import tgs.vote.domain.user.User;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SlackAdapter implements UserOAuth2Port {

    private SlackConfig slackConfig;
    private SlackClient slackClient;

    public SlackAdapter(SlackClient slackClient, SlackConfig slackConfig) {
        this.slackClient = slackClient;
        this.slackConfig = slackConfig;
    }

    public List<SlackMember> getSlackUserList() throws Exception {
        SlackUserResponse response = slackClient.getUserInfo(slackConfig.getSlackToken());
        if (response.ok()) {
            return response.members();
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public User getUserInfo(String authorizationCode) {
        //TODO: Slack OAuth2를 통한 유저 정보 매핑 구현
        
        return null;
    }
}
