package tgs.vote.adapter.model.persistence.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class SlackProfile {
    @JsonProperty("avatar_hash")
    private String avatarHash;
    @JsonProperty("status_text")
    private String statusText;
    @JsonProperty("status_emoji")
    private String statusEmoji;
    @JsonProperty("real_name")
    private String realName;
    @JsonProperty("display_name")
    private String displayName;
    @JsonProperty("real_name_normalized")
    private String realNameNormalized;
    @JsonProperty("display_name_normalized")
    private String displayNameNormalized;
    private String email;
    @JsonProperty("image_24")
    private String image24;
    @JsonProperty("image_32")
    private String image32;
    @JsonProperty("image_48")
    private String image48;
    @JsonProperty("image_72")
    private String image72;
    @JsonProperty("image_192")
    private String image192;
    @JsonProperty("image_512")
    private String image512;
    private String team;
}

