package tgs.vote.adapter.out.model.persistence.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SlackMember {

        private String id;
        @JsonProperty("team_id")
        private String teamId;
        private String name;
        private boolean deleted;
        private String color;
        @JsonProperty("real_name")
        private String realName;
        private String tz;
        @JsonProperty("tz_label")
        private String tzLabel;
        @JsonProperty("tz_offset")
        private int tzOffset;
        private SlackProfile profile;
        @JsonProperty("is_admin")
        private boolean isAdmin;
        @JsonProperty("is_owner")
        private boolean isOwner;
        @JsonProperty("is_primary_owner")
        private boolean isPrimaryOwner;
        @JsonProperty("is_restricted")
        private boolean isRestricted;
        @JsonProperty("is_ultra_restricted")
        private boolean isUltraRestricted;
        @JsonProperty("is_bot")
        private boolean isBot;
        private long updated;
        @JsonProperty("is_app_user")
        private boolean isAppUser;
        @JsonProperty("has_2fa")
        private boolean has2fa;

}
