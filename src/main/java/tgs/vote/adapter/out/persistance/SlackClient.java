package tgs.vote.adapter.out.impl;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import tgs.vote.adapter.out.config.SupabaseFeignClientConfig;
import tgs.vote.adapter.out.model.web.SlackUserResponse;

@FeignClient(name = "slackClient", url = "https://slack.com/api", configuration = SupabaseFeignClientConfig.class)
public interface SlackClient {

    @GetMapping("/users.info")
    SlackUserResponse getUserInfo(@RequestParam("user") String userId);
}
