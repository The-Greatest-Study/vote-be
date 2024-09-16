package tgs.vote.application.in;

import java.util.List;
import tgs.vote.domain.user.User;

public interface GetUserUseCase {
    User findByProviderId(String providerId);

    List<User> findByUserName(String userName);
}
