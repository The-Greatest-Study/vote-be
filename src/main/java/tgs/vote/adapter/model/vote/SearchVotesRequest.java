package tgs.vote.adapter.model.vote;

import static tgs.vote.adapter.model.vote.SearchVotesSortItem.VOTE_START_DATE_TIME;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;
import lombok.Getter;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import tgs.vote.application.model.vote.GetVotesType;
import tgs.vote.application.model.vote.SearchVotesCommand;

@Getter
public class SearchVotesRequest {

    @Schema(
            name = "voteTitle",
            description = "투표 제목",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String voteTitle;

    @Schema(
            name = "voteCreatorName",
            description = "투표 생성자 이름 (%% 검색)",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String voteCreatorName;

    @Schema(
            name = "searchStartDate",
            description = "검색 시작 일자 (투표 시작 일시 기준으로 조회)",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate searchStartDate;

    @Schema(
            name = "searchEndDate",
            description = "검색 종료 일자 (투표 시작 일시 기준으로 조회)",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate searchEndDate;

    @Schema(
            name = "sortDirection",
            description = "정렬 순서 (ASC / DESC)",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private Sort.Direction sortDirection = Sort.Direction.DESC;

    @Schema(
            name = "sortItem",
            description = "정렬할 항목 (voteStartDateTime / voteEndDateTime / voteTitle / voteCreator)",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private SearchVotesSortItem sortItem = VOTE_START_DATE_TIME;

    public SearchVotesCommand toSearchVotesCommandInProcessType(long userId) {
        return SearchVotesCommand.builder()
                .getVotesType(GetVotesType.IN_PROCESS)
                .userId(userId)
                .voteTitle(voteTitle)
                .voteCreatorName(voteCreatorName)
                .searchStartDate(searchStartDate)
                .searchEndDate(searchEndDate)
                .sortDirection(sortDirection)
                .sortItem(sortItem.toGetVotesSortItem())
                .build();
    }

    public SearchVotesCommand toSearchVotesCommandCreatedType(long userId) {
        return SearchVotesCommand.builder()
                .getVotesType(GetVotesType.CREATED)
                .userId(userId)
                .voteTitle(voteTitle)
                .voteCreatorName(voteCreatorName)
                .searchStartDate(searchStartDate)
                .searchEndDate(searchEndDate)
                .sortDirection(sortDirection)
                .sortItem(sortItem.toGetVotesSortItem())
                .build();
    }

    public SearchVotesCommand toSearchVotesCommandParticipatedType(long userId) {
        return SearchVotesCommand.builder()
                .getVotesType(GetVotesType.PARTICIPATED)
                .userId(userId)
                .voteTitle(voteTitle)
                .voteCreatorName(voteCreatorName)
                .searchStartDate(searchStartDate)
                .searchEndDate(searchEndDate)
                .sortDirection(sortDirection)
                .sortItem(sortItem.toGetVotesSortItem())
                .build();
    }
}
