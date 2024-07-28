package tgs.vote.adapter.out;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tgs.vote.adapter.model.persistence.user.SlackMember;
import tgs.vote.adapter.model.persistence.user.UserEntity;
import tgs.vote.adapter.out.persistance.UserJpaRepository;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserAdapter {
    private final SlackAdapter slackAdapter;
    private final UserJpaRepository userJpaRepository;

    public List<UserEntity> mapSlackUserListToUserEntityList() throws Exception {
        List<SlackMember> slackMemberList = slackAdapter.getSlackUserMemberList();
        return slackMemberList.stream()
                .map(UserEntity::from)
                .collect(Collectors.toList());
    }

    public void saveUserList(List<UserEntity> userEntityList) {
        userJpaRepository.saveAll(userEntityList);
    }

}
