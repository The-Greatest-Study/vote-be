package tgs.vote.adapter.out.model.user;


import lombok.Getter;

@Getter
public class SlackUser {

    private String id;
    private String teamId;
    private String name;
    private boolean deleted;
    private String color;
    private String realName;
    private String tz;
    private String tzLabel;
    private int tzOffset;
    private SlackUserProfile profile;
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
