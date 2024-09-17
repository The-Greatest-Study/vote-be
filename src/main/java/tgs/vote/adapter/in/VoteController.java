package tgs.vote.adapter.in;

import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tgs.vote.adapter.mapper.VoteMapper;
import tgs.vote.adapter.model.ResponseDTO;
import tgs.vote.adapter.model.vote.SearchVotesRequest;
import tgs.vote.adapter.model.vote.SearchVotesResponse;
import tgs.vote.adapter.model.vote.VoteCreateRequest;
import tgs.vote.adapter.model.vote.VoteCreateResponse;
import tgs.vote.application.SessionService;
import tgs.vote.application.in.CreateVoteUseCase;
import tgs.vote.application.in.SearchVotesUseCase;
import tgs.vote.application.model.vote.CreateVoteInCommand;
import tgs.vote.application.model.vote.GetVotesResult;

@RequiredArgsConstructor
@Validated
@RequestMapping("/vote")
@RestController
public class VoteController implements VoteSwagger {
    private final CreateVoteUseCase createVoteUseCase;
    private final SearchVotesUseCase searchVotesUseCase;

    private final VoteMapper voteMapper;

    @PostMapping("")
    ResponseDTO<VoteCreateResponse> createVote(@RequestBody VoteCreateRequest request) {
        CreateVoteInCommand command = voteMapper.toCreateVoteInCommand(request);

        Long voteId = createVoteUseCase.createVote(command);

        VoteCreateResponse response = VoteCreateResponse.from(voteId);

        return ResponseDTO.ofSuccess(response);
    }

    @Override
    @GetMapping("/in-process")
    public ResponseDTO<List<SearchVotesResponse>> searchInProcessVotes(
            @ModelAttribute @Valid SearchVotesRequest request) {
        long userIdFromSession = SessionService.getUserIdFromSession();

        List<GetVotesResult> results =
                searchVotesUseCase.searchVotesBy(
                        request.toSearchVotesCommandInProcessType(userIdFromSession));

        return ResponseDTO.ofSuccess(voteMapper.toSearchVotesResponses(results));
    }

    @Override
    @GetMapping("/created")
    public ResponseDTO<List<SearchVotesResponse>> searchMyCreatedVotes(
            @ModelAttribute @Valid SearchVotesRequest request) {
        long userIdFromSession = SessionService.getUserIdFromSession();

        List<GetVotesResult> results =
                searchVotesUseCase.searchVotesBy(
                        request.toSearchVotesCommandCreatedType(userIdFromSession));

        return ResponseDTO.ofSuccess(voteMapper.toSearchVotesResponses(results));
    }

    @Override
    @GetMapping("/participated")
    public ResponseDTO<List<SearchVotesResponse>> searchMyParticipatedVotes(
            @ModelAttribute @Valid SearchVotesRequest request) {
        long userIdFromSession = SessionService.getUserIdFromSession();

        List<GetVotesResult> results =
                searchVotesUseCase.searchVotesBy(
                        request.toSearchVotesCommandParticipatedType(userIdFromSession));

        return ResponseDTO.ofSuccess(voteMapper.toSearchVotesResponses(results));
    }
}
