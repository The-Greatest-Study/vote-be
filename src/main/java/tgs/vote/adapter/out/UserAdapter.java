package tgs.vote.adapter.out;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tgs.vote.adapter.mapper.UserMapper;
import tgs.vote.adapter.model.persistence.user.UserEntity;
import tgs.vote.adapter.out.persistance.UserJpaRepository;
import tgs.vote.application.out.UserPort;
import tgs.vote.domain.user.User;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserAdapter implements UserPort {
    private final SlackAdapter slackAdapter;
    private final UserMapper userMapper;
    private final UserJpaRepository userJpaRepository;

    public List<UserEntity> getUserEntity() throws Exception {
        return slackAdapter.getSlackUserList().stream()
                .map(UserEntity::from).toList();
    }

    @Override
    public User save(User user) {
        UserEntity entity = userMapper.toUserEntity(user);
        userJpaRepository.save(entity);
        return userMapper.toUser(entity);
    }
}
