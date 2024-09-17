package tgs.vote.application.model.vote;

import java.time.LocalDate;
import java.util.List;
import lombok.Builder;
import org.springframework.data.domain.Sort;

@Builder
public record GetVotesCommand(
        GetVotesType getVotesType,
        long userId,
        String voteTitle,
        List<Long> voteCreatorUserIds,
        LocalDate searchStartDate,
        LocalDate searchEndDate,
        Sort.Direction sortDirection,
        GetVotesSortItem sortItem) {}
