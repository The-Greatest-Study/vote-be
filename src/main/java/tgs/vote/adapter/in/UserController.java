package tgs.vote.adapter.in;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tgs.vote.adapter.mapper.UserMapper;
import tgs.vote.adapter.model.SuccessResponse;
import tgs.vote.adapter.model.user.LoginResponse;
import tgs.vote.adapter.model.user.SlackLoginRequest;
import tgs.vote.application.in.LoginUseCase;
import tgs.vote.application.model.user.LoginInCommand;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final LoginUseCase loginUseCase;
    private final UserMapper mapper;

    @PostMapping("/login/slack")
    public SuccessResponse<LoginResponse> loginWithSlack(@RequestBody SlackLoginRequest request) {
        LoginResponse response =
                mapper.toLoginResponse(
                        loginUseCase.login(
                                LoginInCommand.builder()
                                        .authorizationCode(request.code())
                                        .build()));
        return SuccessResponse.of(response);
    }
}
