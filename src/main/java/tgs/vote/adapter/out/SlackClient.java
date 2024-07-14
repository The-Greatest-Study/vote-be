package tgs.vote.adapter.out;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "slackClient", url = "https://slack.com/api")
public interface SlackClient {
    @GetMapping("/users.list")
    String getSlackUserList(@RequestHeader("Authorization") String token);
}
