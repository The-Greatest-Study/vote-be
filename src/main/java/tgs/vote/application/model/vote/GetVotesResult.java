package tgs.vote.application.model.vote;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class GetVotesResult {
    private final Long voteId;
    private final String title;
    private final Long creatorId;
    private final String creatorName;
    private final String thumbnail;
    private final LocalDateTime startDateTime;
    private final LocalDateTime endDateTime;
    private final Long completedUserCount;
    private final Boolean isAvailableToVot;
}
