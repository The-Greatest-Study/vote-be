package tgs.vote.domain.user;

import lombok.Getter;

@Getter
public class User {
    private Long userId;
    private String providerId;
    private String teamId;
    private String name;
    private String image;
}
