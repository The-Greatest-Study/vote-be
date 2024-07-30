package tgs.vote.adapter.in;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tgs.vote.adapter.mapper.UserMapper;
import tgs.vote.adapter.model.web.SuccessResponse;
import tgs.vote.adapter.model.web.user.SlackUserCreateRequest;
import tgs.vote.adapter.model.web.user.SlackUserCreateResponse;
import tgs.vote.application.in.CreateUserUseCase;
import tgs.vote.application.model.user.CreateUserInCommand;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final CreateUserUseCase createUserUseCase;
    private final UserMapper userMapper;

    @PostMapping("/signup/slack")
    SuccessResponse<SlackUserCreateResponse> registerUserWithSlack(@RequestBody SlackUserCreateRequest request) {
        CreateUserInCommand command = userMapper.toCreateUserInCommand(request);

        Long userId = createUserUseCase.registerUserWithSlack(command);
        return SuccessResponse.of(SlackUserCreateResponse.from(userId));
    }
}
