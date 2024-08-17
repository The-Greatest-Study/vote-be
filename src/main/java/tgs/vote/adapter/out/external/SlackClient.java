package tgs.vote.adapter.out.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tgs.vote.adapter.model.persistence.user.SlackUserResponse;
import tgs.vote.adapter.out.config.SupabaseFeignClientConfig;

@FeignClient(name = "slackClient", url = "https://slack.com/api", configuration = SupabaseFeignClientConfig.class)
public interface SlackClient {

    @GetMapping("/users.info")
    SlackUserResponse getUserInfo(@RequestParam("user") String slackToken);

}
