package tgs.vote.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tgs.vote.adapter.mapper.UserMapper;
import tgs.vote.adapter.model.web.user.SlackUserCreateRequest;
import tgs.vote.application.in.CreateUserUseCase;
import tgs.vote.application.in.GetUserUseCase;
import tgs.vote.application.model.user.CreateUserInCommand;
import tgs.vote.application.out.UserOAuth2Port;
import tgs.vote.application.out.UserPort;
import tgs.vote.domain.user.User;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService implements GetUserUseCase, CreateUserUseCase {
    private final UserPort userPort;
    private final UserOAuth2Port userOAuth2Port;

    @Override
    public List<User> getUserList() {
        return null;
    }

    @Override
    public Long registerUserWithSlack(CreateUserInCommand command) {
        User savedUser = userOAuth2Port.getUserInfo(command.authorizationCode());
        User user = userPort.save(savedUser);
        return user.getUserId();
    }
}
