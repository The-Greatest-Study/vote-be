package tgs.vote.adapter.in;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tgs.vote.adapter.in.model.VoteCreateRequest;
import tgs.vote.adapter.out.model.web.VoteCreateResponse;
import tgs.vote.adapter.out.model.web.VoteGetListResponse;
import tgs.vote.adapter.out.model.web.SuccessResponse;
import tgs.vote.application.in.CreateVoteUseCase;
import tgs.vote.application.in.GetVoteListUseCase;
import tgs.vote.domain.vote.model.Vote;

@RequiredArgsConstructor
@RestController
@RequestMapping("/vote")
public class VoteController {
    private final GetVoteListUseCase getVoteListUseCase;
    private final CreateVoteUseCase createVoteUseCase;

    @GetMapping("/list")
    SuccessResponse<List<VoteGetListResponse>> getVoteList() throws Exception {
        List<Vote> results = getVoteListUseCase.getVoteList();
        List<VoteGetListResponse> responses =
                results.stream().map(VoteGetListResponse::from).toList();

        return SuccessResponse.of(responses);
    }

    @PostMapping("")
    SuccessResponse<VoteCreateResponse> createVote(@RequestBody VoteCreateRequest voteCreateRequest) throws Exception {
        Long voteId = createVoteUseCase.createVote(voteCreateRequest);
        VoteCreateResponse response = VoteCreateResponse.from(voteId);
        return SuccessResponse.of(response);
    }
}
