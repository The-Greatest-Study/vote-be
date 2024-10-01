package tgs.vote.application.model.vote;

import java.time.LocalDate;
import java.util.List;
import lombok.Builder;
import org.springframework.data.domain.Sort;

@Builder
public record SearchVotesCommand(
        GetVotesType getVotesType,
        long userId,
        String voteTitle,
        String voteCreatorName,
        LocalDate searchStartDate,
        LocalDate searchEndDate,
        Sort.Direction sortDirection,
        GetVotesSortItem sortItem) {
    public GetVotesCommand toGetVotesCommand(List<Long> voteCreatorUserIds) {
        return GetVotesCommand.builder()
                .getVotesType(getVotesType)
                .userId(userId)
                .voteTitle(voteTitle)
                .voteCreatorUserIds(voteCreatorUserIds)
                .searchStartDate(searchStartDate)
                .searchEndDate(searchEndDate)
                .sortDirection(sortDirection)
                .sortItem(sortItem)
                .build();
    }
}
