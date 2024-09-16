package tgs.vote.application.out;

import tgs.vote.adapter.model.user.UserEntity;
import tgs.vote.application.model.user.CreateUserOutCommand;
import tgs.vote.application.model.user.GetUserByProviderIdOutCommand;
import tgs.vote.domain.user.User;

public interface UserPort {
    UserEntity findByProviderId(GetUserByProviderIdOutCommand providerId);

    UserEntity createUser(CreateUserOutCommand user);
}
