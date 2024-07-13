package tgs.vote.adapter.in;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import tgs.vote.adapter.out.VoteGetListResponse;
import tgs.vote.adapter.out.model.SuccessResponse;
import tgs.vote.application.in.GetVoteListUseCase;
import tgs.vote.domain.vote.model.Vote;

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

    @PostMapping("")
    SuccessResponse<VoteCreateReponse> createVote throws Exception {
        return null;
    }
}
