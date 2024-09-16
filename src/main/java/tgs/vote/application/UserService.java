package tgs.vote.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tgs.vote.adapter.mapper.UserMapper;
import tgs.vote.adapter.model.user.UserEntity;
import tgs.vote.application.in.CreateUserUseCase;
import tgs.vote.application.in.GetUserUseCase;
import tgs.vote.application.model.user.CreateUserOutCommand;
import tgs.vote.application.model.user.GetUserByProviderIdOutCommand;
import tgs.vote.application.out.UserPort;
import tgs.vote.domain.user.User;

@RequiredArgsConstructor
@Service
public class UserService implements GetUserUseCase, CreateUserUseCase {
    private final UserPort userPort;
    private final UserMapper mapper;

    @Override
    public User findByProviderId(String providerId) {
        return mapper.toUser(userPort.findByProviderId(
                GetUserByProviderIdOutCommand.builder().providerId(providerId).build()));
    }

    @Override
    public User createUser(CreateUserOutCommand user) {
        return mapper.toUser(userPort.createUser(user));
    }
}
