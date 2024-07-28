package tgs.vote.adapter.out.model.web;

import lombok.Getter;

@Getter
public class SlackUserResponse {
    private boolean ok;
    private User user;

    @Getter
    public static class User {
        private String id;
        private String teamId;
        private String name;
        private boolean deleted;
        private String color;
        private String realName;
        private String tz;
        private String tzLabel;
        private int tzOffset;
        private Profile profile;
        private boolean isAdmin;
        private boolean isOwner;
        private boolean isPrimaryOwner;
        private boolean isRestricted;
        private boolean isUltraRestricted;
        private boolean isBot;
        private long updated;
        private boolean isAppUser;
        private boolean has2fa;
    }

    @Getter
    public static class Profile {
        private String avatarHash;
        private String statusText;
        private String statusEmoji;
        private String realName;
        private String displayName;
        private String realNameNormalized;
        private String displayNameNormalized;
        private String email;
        private String imageOriginal;
        private String image24;
        private String image32;
        private String image48;
        private String image72;
        private String image192;
        private String image512;
        private String team;
    }

}
