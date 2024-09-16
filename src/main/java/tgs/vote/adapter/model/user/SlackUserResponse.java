package tgs.vote.adapter.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.slack.api.model.ResponseMetadata;

import java.util.List;

public record SlackUserResponse(
        boolean ok,
        SlackMember user) {}
