package tgs.vote.adapter.out.model.persistence.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import tgs.vote.adapter.out.model.persistence.BaseEntity;


@Entity(name = "tb_user")
public class UserEntity extends BaseEntity {

    @Id
    private Long userId;
    private String providerId;
    private String teamId;
    private String name;
    private String email;
    private String image;
}
