package tgs.vote.adapter.model.vote;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class VoteDetailResult {
    private final Long voteId;
    private final String voteTitle;
    private final List<QuestionInVote> questions;

    @Builder
    private VoteDetailResult(Long voteId, String voteTitle, List<QuestionInVote> questions) {
        this.voteId = voteId;
        this.voteTitle = voteTitle;
        this.questions = questions != null ? questions : List.of();
    }

    @Getter
    @Builder
    public static class QuestionInVote {
        private final Long questionId;
        private final String questionContent;
        private final List<ChoiceInQuestion> choices;
    }

    @Getter
    @Builder
    public static class ChoiceInQuestion {
        private final Long choiceId;
        private final String choiceContent;
    }
}
