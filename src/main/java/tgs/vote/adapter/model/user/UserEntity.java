package tgs.vote.adapter.model.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;
import tgs.vote.adapter.model.BaseEntity;

@Entity(name = "tb_user")
@NoArgsConstructor
public class UserEntity extends BaseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long userId;

    private String providerId;
    private String teamId;
    private String name;
    private String email;
    private String image;

    public UserEntity(String providerId, String teamId, String name, String email, String image) {
        this.providerId = providerId;
        this.teamId = teamId;
        this.name = name;
        this.email = email;
        this.image = image;
    }

    public static UserEntity from(SlackMember slackMember) {
        return new UserEntity(
                slackMember.id(),
                slackMember.teamId(),
                slackMember.name(),
                slackMember.email(),
                slackMember.image());
    }
}
