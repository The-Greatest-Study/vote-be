package tgs.vote.application.out;

import tgs.vote.domain.user.User;
import tgs.vote.domain.vote.Vote;

import java.util.List;

public interface UserPort {
    User save(User user);
}
