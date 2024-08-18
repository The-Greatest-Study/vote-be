package tgs.vote.adapter.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SlackMember(
        String id,
        @JsonProperty("team_id") String teamId,
        String name,
        boolean deleted,
        String color,
        @JsonProperty("real_name") String realName,
        String tz,
        @JsonProperty("tz_label") String tzLabel,
        @JsonProperty("tz_offset") int tzOffset,
        SlackProfile profile,
        @JsonProperty("is_admin") boolean isAdmin,
        @JsonProperty("is_owner") boolean isOwner,
        @JsonProperty("is_primary_owner") boolean isPrimaryOwner,
        @JsonProperty("is_restricted") boolean isRestricted,
        @JsonProperty("is_ultra_restricted") boolean isUltraRestricted,
        @JsonProperty("is_bot") boolean isBot,
        long updated,
        @JsonProperty("is_app_user") boolean isAppUser,
        @JsonProperty("has_2fa") boolean has2fa) {
    public String email() {
        return profile.email();
    }

    public String image() {
        return profile.image192();
    }
}
