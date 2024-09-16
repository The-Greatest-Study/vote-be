package tgs.vote.adapter.model.vote;

import java.time.LocalDateTime;
import org.springframework.data.domain.Sort;
import tgs.vote.application.model.vote.GetVotesSortItem;
import tgs.vote.application.model.vote.GetVotesType;
import tgs.vote.application.model.vote.SearchVotesCommand;

public record SearchVotesRequest(
        String voteTitle,
        String voteCreatorName,
        LocalDateTime searchStartDateTime,
        LocalDateTime searchEndDateTime,
        Sort.Order sortOrder,
        GetVotesSortItem sortItem) {
    public SearchVotesCommand toSearchVotesCommandInProcessType(long userId) {
        return SearchVotesCommand.builder()
                .getVotesType(GetVotesType.IN_PROCESS)
                .userId(userId)
                .voteTitle(voteTitle)
                .voteCreatorName(voteCreatorName)
                .searchStartDateTime(searchStartDateTime)
                .searchEndDateTime(searchEndDateTime)
                .sortOrder(sortOrder)
                .sortItem(sortItem)
                .build();
    }

    public SearchVotesCommand toSearchVotesCommandCreatedType(long userId) {
        return SearchVotesCommand.builder()
                .getVotesType(GetVotesType.CREATED)
                .userId(userId)
                .voteTitle(voteTitle)
                .voteCreatorName(voteCreatorName)
                .searchStartDateTime(searchStartDateTime)
                .searchEndDateTime(searchEndDateTime)
                .sortOrder(sortOrder)
                .sortItem(sortItem)
                .build();
    }

    public SearchVotesCommand toSearchVotesCommandParticipatedType(long userId) {
        return SearchVotesCommand.builder()
                .getVotesType(GetVotesType.PARTICIPATED)
                .userId(userId)
                .voteTitle(voteTitle)
                .voteCreatorName(voteCreatorName)
                .searchStartDateTime(searchStartDateTime)
                .searchEndDateTime(searchEndDateTime)
                .sortOrder(sortOrder)
                .sortItem(sortItem)
                .build();
    }
}
