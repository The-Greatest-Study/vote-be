package tgs.vote.domain.user;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class User {
    private Long userId;
    private String providerId;
    private String teamId;
    private String name;
    private String email;
    private String image;
}
