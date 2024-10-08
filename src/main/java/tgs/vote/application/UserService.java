package tgs.vote.application;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tgs.vote.adapter.mapper.UserMapper;
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
    @Transactional // TODO: 리드온니가 안됨...
    public User findByProviderId(String providerId) {
        User user =
                userPort.findByProviderId(
                        GetUserByProviderIdOutCommand.builder().providerId(providerId).build());

        if (user == null) {
            throw new RuntimeException("User not found");
        }
        return user;
    }

    @Override
    public User createUser(CreateUserOutCommand user) {
        return userPort.createUser(user);
    }
}
