package tgs.vote.adapter.in;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tgs.vote.adapter.mapper.VoteMapper;
import tgs.vote.adapter.model.SuccessResponse;
import tgs.vote.adapter.model.vote.DoVoteCreateRequest;
import tgs.vote.adapter.model.vote.VoteCreateRequest;
import tgs.vote.adapter.model.vote.VoteCreateResponse;
import tgs.vote.adapter.model.vote.VoteGetListResponse;
import tgs.vote.application.in.CreateDoVoteUseCase;
import tgs.vote.application.in.CreateVoteUseCase;
import tgs.vote.application.in.GetVoteListUseCase;
import tgs.vote.application.in.GetVoteUseCase;
import tgs.vote.application.model.vote.CreateDoVoteInCommand;
import tgs.vote.application.model.vote.CreateVoteInCommand;
import tgs.vote.domain.vote.Vote;

@RequiredArgsConstructor
@RestController
@RequestMapping("/vote")
public class VoteController {
    private final GetVoteListUseCase getVoteListUseCase;
    private final GetVoteUseCase getVoteUseCase;
    private final CreateVoteUseCase createVoteUseCase;
    private final CreateDoVoteUseCase createDoVoteUseCase;
    private final VoteMapper voteMapper;

    @GetMapping("/list")
    SuccessResponse<List<VoteGetListResponse>> getVoteList() {
        List<Vote> results = getVoteListUseCase.getVoteList();
        List<VoteGetListResponse> responses =
                results.stream().map(VoteGetListResponse::from).toList();

        return SuccessResponse.of(responses);
    }

    @GetMapping("/id")
    SuccessResponse<VoteGetListResponse> getVote(@RequestParam String voteId) {
        Vote result = getVoteUseCase.getVote(voteId);
        VoteGetListResponse response = VoteGetListResponse.from(result);

        return SuccessResponse.of(response);
    }

    @PostMapping("/cast")
    SuccessResponse<VoteCreateResponse> createDoVote(@RequestBody DoVoteCreateRequest request) {
        
        CreateDoVoteInCommand command = voteMapper.toCreateDoVoteInCommand(request);
        Long voteId = createDoVoteUseCase.createDoVote(command);

        VoteCreateResponse response = VoteCreateResponse.from(voteId);

        return SuccessResponse.of(response);
    }

    @PostMapping("")
    SuccessResponse<VoteCreateResponse> createVote(@RequestBody VoteCreateRequest request) {
        CreateVoteInCommand command = voteMapper.toCreateVoteInCommand(request);

        Long voteId = createVoteUseCase.createVote(command);

        VoteCreateResponse response = VoteCreateResponse.from(voteId);

        return SuccessResponse.of(response);
    }
}
