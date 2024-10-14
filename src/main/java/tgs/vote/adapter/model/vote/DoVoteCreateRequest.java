package tgs.vote.adapter.model.vote;

import java.util.List;
import tgs.vote.domain.vote.Question;

public record DoVoteCreateRequest(
        Long voteId,
        List<Question> questionList) {}
