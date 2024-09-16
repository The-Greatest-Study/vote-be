package tgs.vote.adapter.model.vote;

import java.time.LocalDateTime;

public record SearchVotesResponse(
        long voteId,
        String title,
        long creator,
        String thumbnail,
        LocalDateTime startDateTime,
        LocalDateTime endDateTime,
        int completedUserCount,
        boolean isAvailableToVote) {}
