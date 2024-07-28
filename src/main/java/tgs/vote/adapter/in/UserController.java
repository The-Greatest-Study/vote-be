package tgs.vote.adapter.in;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tgs.vote.adapter.out.UserAdapter;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserAdapter userAdapter;

    @PostMapping("/signup")
    public void saveUserList() throws Exception {
        userAdapter.saveUserList(userAdapter.mapSlackUserListToUserEntityList());
    }
}
