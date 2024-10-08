package tgs.vote.adapter.out.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import tgs.vote.adapter.model.user.SlackOauth2Request;
import tgs.vote.adapter.model.user.SlackOauth2Response;
import tgs.vote.adapter.model.user.SlackUserListResponse;
import tgs.vote.adapter.out.config.SupabaseFeignClientConfig;

@FeignClient(
        name = "slackClient",
        url = "https://slack.com/api",
        configuration = SupabaseFeignClientConfig.class)
public interface SlackClient {

    @GetMapping("/users.info")
    SlackUserListResponse getUserInfo(@RequestParam("user") String slackToken);

    @PostMapping("/oauth.v2.access")
    SlackOauth2Response oauthV2Access(@RequestBody SlackOauth2Request request);
}
