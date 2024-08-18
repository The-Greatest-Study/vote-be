package tgs.vote.adapter.model.vote;

import java.time.LocalDateTime;
import java.util.List;
import tgs.vote.domain.vote.Question;

public record VoteCreateRequest(
        String voteTitle,
        String voteDescription,
        String voteThumbnail,
        Long voteCreator,
        String voteOpenStatus,
        String voteAnonymousAvailableYn,
        String voteInProcessResultOpenStatus,
        String voteEndResultOpenStatus,
        String voteAgainAvailableYn,
        LocalDateTime voteCreateDatetime,
        LocalDateTime voteStartDatetime,
        LocalDateTime voteEndDatetime,
        List<Question> questionList) {}
