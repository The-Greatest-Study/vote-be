package tgs.vote.adapter.out.model.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import tgs.vote.adapter.out.model.persistence.BaseEntity;

@Getter
@Entity(name = "tb_user")
public class UserEntity extends BaseEntity {

    @Id
    private Long userId;
    private String providerId;
    private String teamId;
    private String name;
    private String image;
}
