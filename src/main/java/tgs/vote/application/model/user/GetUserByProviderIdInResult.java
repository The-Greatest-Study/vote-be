package tgs.vote.application.model.user;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class GetUserByProviderIdInResult {

    private Long userId;
    private String providerId;
    private String teamId;
    private String name;
    private String email;
    private String image;
}
