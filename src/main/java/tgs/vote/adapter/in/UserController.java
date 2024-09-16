package tgs.vote.adapter.in;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tgs.vote.adapter.mapper.UserMapper;
import tgs.vote.adapter.model.SuccessResponse;
import tgs.vote.adapter.model.user.LoginResponse;
import tgs.vote.adapter.model.user.SignUpResponse;
import tgs.vote.adapter.model.user.SlackLoginRequest;
import tgs.vote.adapter.model.user.SlackSignUpRequest;
import tgs.vote.application.in.SlackUserUseCase;
import tgs.vote.application.model.user.LoginInCommand;
import tgs.vote.application.model.user.SignUpInCommand;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final SlackUserUseCase slackUserUseCase;
    private final UserMapper mapper;

    @PostMapping("/login/slack")
    public SuccessResponse<LoginResponse> loginWithSlack(@RequestBody SlackLoginRequest request) {
        LoginResponse response =
                mapper.toLoginResponse(
                        slackUserUseCase.login(
                                LoginInCommand.builder()
                                        .authorizationCode(request.code())
                                        .build()));
        return SuccessResponse.of(response);
    }

    @PostMapping("/signup/slack")
    public SuccessResponse<SignUpResponse> signUpWithSlack(@RequestBody SlackSignUpRequest request) {
        SignUpResponse response =
                mapper.toSignUpResponse(
                        slackUserUseCase.signUp(SignUpInCommand.builder()
                                        .authorizationCode(request.code())
                                        .redirectUri(request.redirectUri())
                                .build()));
        return SuccessResponse.of(response);
    }
}
