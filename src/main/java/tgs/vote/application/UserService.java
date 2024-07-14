package tgs.vote.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tgs.vote.application.in.GetUserUseCase;
import tgs.vote.domain.user.User;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService implements GetUserUseCase {
    @Override
    public List<User> getUserList() {
        return null;
    }
}
