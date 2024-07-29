package tgs.vote.adapter.out;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tgs.vote.adapter.model.persistence.user.UserEntity;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserAdapter {
    private final SlackAdapter slackAdapter;

    public List<UserEntity> getUserEntity() throws Exception {
        return slackAdapter.getSlackUserList().stream()
                .map(UserEntity::from).toList();
    }
}
