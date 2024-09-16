package tgs.vote.application.model.user;

import lombok.Builder;

@Builder
public class CreateUserOutCommand {

    private Long userId;
    private String providerId;
    private String teamId;
    private String name;
    private String email;
    private String image;
}
