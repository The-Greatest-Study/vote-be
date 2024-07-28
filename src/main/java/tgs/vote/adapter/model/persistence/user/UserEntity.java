package tgs.vote.adapter.model.persistence.user;

import com.slack.api.Slack;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import tgs.vote.adapter.model.persistence.BaseEntity;

@Entity(name = "tb_user")
public class UserEntity extends BaseEntity {
    @Id private Long userId;
    private String providerId;
    private String teamId;
    private String name;
    private String email;
    private String image;

    public static UserEntity from(SlackMember slackMember) {
        UserEntity userEntity = new UserEntity();
        userEntity.providerId = slackMember.getId();
        userEntity.teamId = slackMember.getTeamId();
        userEntity.name = slackMember.getName();
        userEntity.email = slackMember.getEmail();
        userEntity.image = slackMember.getImage();
        return userEntity;
    }
}
