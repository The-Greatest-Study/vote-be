package tgs.vote.application.model.vote;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import org.springframework.data.domain.Sort;

@Builder
public record GetVotesCommand(
        GetVotesType getVotesType,
        long userId,
        String voteTitle,
        List<Long> voteCreatorUserIds,
        LocalDateTime searchStartDateTime,
        LocalDateTime searchEndDateTime,
        Sort.Order sortOrder,
        GetVotesSortItem sortItem) {}
