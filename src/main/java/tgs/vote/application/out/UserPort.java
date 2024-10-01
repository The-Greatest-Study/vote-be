package tgs.vote.application.out;

import java.util.List;
import tgs.vote.application.model.user.GetUserByProviderIdOutCommand;
import tgs.vote.domain.user.User;

public interface UserPort {
    User findByProviderId(GetUserByProviderIdOutCommand providerId);

    List<User> findByUserName(String userName);
}
