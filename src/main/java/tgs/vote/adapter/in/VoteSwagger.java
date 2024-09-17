package tgs.vote.adapter.in;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import tgs.vote.adapter.model.ResponseDTO;
import tgs.vote.adapter.model.vote.SearchVotesRequest;
import tgs.vote.adapter.model.vote.SearchVotesResponse;

@Tag(name = "VOTE", description = "투표")
public interface VoteSwagger {
    @Operation(description = "로그인 한 사용자가 볼 수 있고 현재 진행중인 투표 목록 조회 API")
    @GetMapping("/in-process")
    ResponseDTO<List<SearchVotesResponse>> searchInProcessVotes(
            @ParameterObject @ModelAttribute @Valid SearchVotesRequest request);

    @Operation(description = "로그인 한 사용자가 생성한 투표 목록 조회 API")
    @GetMapping("/created")
    ResponseDTO<List<SearchVotesResponse>> searchMyCreatedVotes(
            @ParameterObject @ModelAttribute @Valid SearchVotesRequest request);

    @Operation(description = "로그인 한 사용자가 참여한 투표 목록 조회 API")
    @GetMapping("/participated")
    ResponseDTO<List<SearchVotesResponse>> searchMyParticipatedVotes(
            @ParameterObject @ModelAttribute @Valid SearchVotesRequest request);
}
