package tgs.vote.adapter.in;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tgs.vote.adapter.mapper.VoteMapper;
import tgs.vote.adapter.model.web.SuccessResponse;
import tgs.vote.adapter.model.web.vote.VoteCreateRequest;
import tgs.vote.adapter.model.web.vote.VoteCreateResponse;
import tgs.vote.adapter.model.web.vote.VoteGetListResponse;
import tgs.vote.application.in.CreateVoteUseCase;
import tgs.vote.application.in.GetVoteListUseCase;
import tgs.vote.application.model.vote.CreateVoteInCommand;
import tgs.vote.domain.vote.Vote;

@RequiredArgsConstructor
@RestController
@RequestMapping("/vote")
public class VoteController {
    private final GetVoteListUseCase getVoteListUseCase;
    private final CreateVoteUseCase createVoteUseCase;
    private final VoteMapper voteMapper;

    @GetMapping("/list")
    SuccessResponse<List<VoteGetListResponse>> getVoteList() {
        List<Vote> results = getVoteListUseCase.getVoteList();
        List<VoteGetListResponse> responses =
                results.stream().map(VoteGetListResponse::from).toList();

        return SuccessResponse.of(responses);
    }

    @PostMapping("")
    SuccessResponse<VoteCreateResponse> createVote(@RequestBody VoteCreateRequest request) {
        CreateVoteInCommand command = voteMapper.toCreateVoteInCommand(request);

        Long voteId = createVoteUseCase.createVote(command);

        VoteCreateResponse response = VoteCreateResponse.from(voteId);

        return SuccessResponse.of(response);
    }
}
