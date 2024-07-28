package tgs.vote.adapter.out.model.persistence.user;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.slack.api.model.ResponseMetadata;
import lombok.Getter;

import java.util.List;

@Getter
public class SlackUser {
    private boolean ok;
    private List<SlackMember> members;
    @JsonProperty("cache_ts")
    private long cacheTs;
    @JsonProperty("response_metadata")
    private ResponseMetadata responseMetadata;
}
