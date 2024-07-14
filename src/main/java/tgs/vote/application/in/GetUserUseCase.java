package tgs.vote.application.in;

import tgs.vote.domain.user.User;

import java.util.List;

public interface GetUserUseCase {
    List<User> getUserList();
}
