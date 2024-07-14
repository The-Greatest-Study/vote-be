package tgs.vote.adapter.in;

import java.util.List;

import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tgs.vote.adapter.out.VoteGetListResponse;
import tgs.vote.adapter.out.model.SuccessResponse;
import tgs.vote.application.in.GetVoteListUseCase;
import tgs.vote.domain.vote.Vote;
import tgs.vote.domain.vote.VoteDetail;

@RequiredArgsConstructor
@RestController
public class VoteController {
    private final GetVoteListUseCase getVoteListUseCase;

    @GetMapping("/vote/list")
    SuccessResponse<List<VoteGetListResponse>> getVoteList() throws Exception {
        List<Vote> results = getVoteListUseCase.getVoteList();
        List<VoteGetListResponse> responses =
                results.stream().map(VoteGetListResponse::from).toList();

        return SuccessResponse.of(responses);
    }

    @GetMapping("/vote/{voteId}")
    SuccessResponse<VoteDetail> getVoteDetails(@PathVariable @Positive Long voteId) {
        VoteDetail result = getVoteListUseCase.getVoteDetail(voteId);
        return SuccessResponse.of(result);
    }
}
