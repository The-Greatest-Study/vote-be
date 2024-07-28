package tgs.vote.adapter.out;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tgs.vote.adapter.model.persistence.user.UserEntity;

@Component
@RequiredArgsConstructor
public class UserAdapter {
    private final SlackAdapter slackAdapter;

    public UserEntity getUserEntity() {
        slackAdapter.getSlackUserList();
    }
}
