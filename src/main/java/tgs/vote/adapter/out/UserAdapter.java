package tgs.vote.adapter.out;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tgs.vote.adapter.mapper.UserMapper;
import tgs.vote.adapter.model.user.UserEntity;
import tgs.vote.adapter.out.persistance.UserJpaRepository;
import tgs.vote.application.model.user.CreateUserOutCommand;
import tgs.vote.application.model.user.GetUserByProviderIdOutCommand;
import tgs.vote.application.out.UserPort;
import tgs.vote.domain.user.User;

@Component
@RequiredArgsConstructor
public class UserAdapter implements UserPort {
    private final UserJpaRepository repository;
    private final UserMapper mapper;

    @Override
    public User findByProviderId(GetUserByProviderIdOutCommand command) {
        return mapper.toUser(
                repository.findByProviderId(command.providerId).orElse(new UserEntity()));
    }

    @Override
    public User createUser(CreateUserOutCommand user) {
        return mapper.toUser(repository.save(mapper.toUserEntity(user)));
    }
}
