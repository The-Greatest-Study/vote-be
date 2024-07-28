package tgs.vote.domain.vote;

import java.util.List;
import lombok.Data;
import tgs.vote.domain.vote.enums.QuestionType;

@Data
public class Question {
    private Long questionId;
    private Long voteId;
    private String questionContent;
    private QuestionType questionType;
    private String canAddAnswerChoiceYn;
    private List<Choice> questionChoiceList;
}
