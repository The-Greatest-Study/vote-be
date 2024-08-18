package tgs.vote.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tgs.vote.application.in.GetUserUseCase;
import tgs.vote.application.model.user.GetUserByProviderIdOutCommand;
import tgs.vote.application.out.UserPort;
import tgs.vote.domain.user.User;

@RequiredArgsConstructor
@Service
public class UserService implements GetUserUseCase {
    private final UserPort userPort;

    @Override
    public User findByProviderId(String providerId) {
        return userPort.findByProviderId(
                GetUserByProviderIdOutCommand.builder().providerId(providerId).build());
    }
}
