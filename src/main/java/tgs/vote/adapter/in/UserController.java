package tgs.vote.adapter.in;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tgs.vote.adapter.mapper.VoteMapper;
import tgs.vote.adapter.model.web.SuccessResponse;
import tgs.vote.adapter.model.web.user.UserCreateRequest;
import tgs.vote.adapter.model.web.vote.VoteCreateRequest;
import tgs.vote.adapter.model.web.vote.VoteCreateResponse;
import tgs.vote.adapter.model.web.vote.VoteGetListResponse;
import tgs.vote.application.in.CreateUserUseCase;
import tgs.vote.application.in.CreateVoteUseCase;
import tgs.vote.application.in.GetUserUseCase;
import tgs.vote.application.in.GetVoteListUseCase;
import tgs.vote.application.model.vote.CreateVoteInCommand;
import tgs.vote.domain.vote.Vote;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final CreateUserUseCase createUserUseCase;

    @PostMapping("/signup/slack")
    SuccessResponse<UserCreateResponse> registerUserWithSlack(@RequestBody UserCreateRequest request) {
        UserCreateResponse response = createUserUseCase.createUser(request);
        return SuccessResponse.of(response);
    }
}
