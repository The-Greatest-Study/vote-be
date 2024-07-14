package tgs.vote.adapter.out.model.user;


import lombok.Getter;

@Getter
public class SlackUserProfile {
    private String avatarHash;
    private String statusText;
    private String statusEmoji;
    private String realName;
    private String displayName;
    private String realNameNormalized;
    private String displayNameNormalized;
    private String email;
    private String image24;
    private String image32;
    private String image48;
    private String image72;
    private String image192;
    private String image512;
    private String team;
}
