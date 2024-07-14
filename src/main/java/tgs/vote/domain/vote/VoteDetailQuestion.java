package tgs.vote.domain.vote;

import lombok.Builder;
import lombok.Getter;
import tgs.vote.domain.question.QuestionType;

@Builder
@Getter
public class VoteDetailQuestion {
    private Long questionId;
    private String questionContent;
    private QuestionType questionType;
    private String canAddChoiceYn;
}
