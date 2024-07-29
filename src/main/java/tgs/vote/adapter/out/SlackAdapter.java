package tgs.vote.adapter.out;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tgs.vote.adapter.model.persistence.user.SlackMember;
import tgs.vote.adapter.out.config.SlackConfig;
import tgs.vote.adapter.model.persistence.user.SlackUserResponse;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SlackAdapter {

    private SlackConfig slackConfig;
    private SlackClient slackClient;

    public SlackAdapter(SlackClient slackClient, SlackConfig slackConfig) {
        this.slackClient = slackClient;
        this.slackConfig = slackConfig;
    }

    public List<SlackMember> getSlackUserList() throws Exception {
        String response = slackClient.getSlackUserList(slackConfig.getSlackToken());
        ObjectMapper mapper = new ObjectMapper();
        SlackUserResponse slackUserResponse = mapper.readValue(response, SlackUserResponse.class);
        if (slackUserResponse.ok()) {
            return slackUserResponse.members();
        } else {
            return Collections.emptyList();
        }
    }
}
