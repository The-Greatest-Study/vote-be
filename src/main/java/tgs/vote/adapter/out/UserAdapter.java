package tgs.vote.adapter.out;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tgs.vote.adapter.mapper.UserMapper;
import tgs.vote.adapter.out.persistance.UserJpaRepository;
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
        return repository.findByProviderId(command.providerId).map(mapper::toUser).orElse(null);
    }
}
