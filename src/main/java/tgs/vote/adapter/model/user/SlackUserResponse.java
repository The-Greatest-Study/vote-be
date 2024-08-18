package tgs.vote.adapter.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.slack.api.model.ResponseMetadata;
import java.util.List;

public record SlackUserResponse(
        boolean ok,
        List<SlackMember> members,
        @JsonProperty("cache_ts") long cacheTs,
        @JsonProperty("response_metadata") ResponseMetadata responseMetadata) {}
