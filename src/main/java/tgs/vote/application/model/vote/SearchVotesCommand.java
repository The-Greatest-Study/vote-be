package tgs.vote.application.model.vote;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.domain.Sort;

public record SearchVotesCommand(
        GetVotesType getVotesType,
        long userId,
        String voteTitle,
        String voteCreatorName,
        LocalDateTime searchStartDateTime,
        LocalDateTime searchEndDateTime,
        Sort.Order sortOrder,
        GetVotesSortItem sortItem) {
    public GetVotesCommand toGetVotesCommand(List<Long> voteCreatorUserIds) {
        return GetVotesCommand.builder()
                .getVotesType(getVotesType)
                .userId(userId)
                .voteTitle(voteTitle)
                .voteCreatorUserIds(voteCreatorUserIds)
                .searchStartDateTime(searchStartDateTime)
                .searchEndDateTime(searchEndDateTime)
                .sortOrder(sortOrder)
                .sortItem(sortItem)
                .build();
    }
}
