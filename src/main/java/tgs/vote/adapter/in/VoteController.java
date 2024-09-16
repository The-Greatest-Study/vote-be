package tgs.vote.adapter.in;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tgs.vote.adapter.mapper.VoteMapper;
import tgs.vote.adapter.model.ResponseDTO;
import tgs.vote.adapter.model.vote.VoteCreateRequest;
import tgs.vote.adapter.model.vote.VoteCreateResponse;
import tgs.vote.application.in.CreateVoteUseCase;
import tgs.vote.application.model.vote.CreateVoteInCommand;

@RequiredArgsConstructor
@RestController
@RequestMapping("/vote")
public class VoteController {
    private final CreateVoteUseCase createVoteUseCase;
    private final VoteMapper voteMapper;

    @PostMapping("")
    ResponseDTO<VoteCreateResponse> createVote(@RequestBody VoteCreateRequest request) {
        CreateVoteInCommand command = voteMapper.toCreateVoteInCommand(request);

        Long voteId = createVoteUseCase.createVote(command);

        VoteCreateResponse response = VoteCreateResponse.from(voteId);

        return ResponseDTO.ofSuccess(response);
    }
}
