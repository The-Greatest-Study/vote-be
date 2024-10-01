package tgs.vote.application;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    @Transactional(readOnly = true)
    @Override
    public List<User> findByUserName(String userName) {
        return userPort.findByUserName(userName);
    }
}
