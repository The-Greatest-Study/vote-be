package tgs.vote.application.in;

import tgs.vote.domain.user.User;

public interface GetUserUseCase {
    User findByProviderId(String providerId);
}
