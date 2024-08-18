package tgs.vote.adapter.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SlackProfile(
        @JsonProperty("avatar_hash") String avatarHash,
        @JsonProperty("status_text") String statusText,
        @JsonProperty("status_emoji") String statusEmoji,
        @JsonProperty("real_name") String realName,
        @JsonProperty("display_name") String displayName,
        @JsonProperty("real_name_normalized") String realNameNormalized,
        @JsonProperty("display_name_normalized") String displayNameNormalized,
        String email,
        @JsonProperty("image_24") String image24,
        @JsonProperty("image_32") String image32,
        @JsonProperty("image_48") String image48,
        @JsonProperty("image_72") String image72,
        @JsonProperty("image_192") String image192,
        @JsonProperty("image_512") String image512,
        String team) {}
