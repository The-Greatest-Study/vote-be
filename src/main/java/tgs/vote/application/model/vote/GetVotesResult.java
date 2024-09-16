package tgs.vote.application.model.vote;

import java.time.LocalDateTime;

public record GetVotesResult(
        long voteId,
        String title,
        long creator,
        String thumbnail,
        LocalDateTime startDateTime,
        LocalDateTime endDateTime,
        int completedUserCount,
        boolean isAvailableToVote) {}
