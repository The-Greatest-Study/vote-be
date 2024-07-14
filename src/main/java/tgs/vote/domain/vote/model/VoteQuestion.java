package tgs.vote.domain.vote.model;

import lombok.Getter;
import tgs.vote.adapter.out.model.persistence.vote.QuestionEntity;
import tgs.vote.adapter.out.model.persistence.vote.QuestionEntityId;
import tgs.vote.domain.vote.enums.QuestionType;

import java.util.List;


@Getter
public class VoteQuestion {
    private Long questionId;
    private Long voteId;
    private String questionContent;
    private QuestionType questionType;
    private String canAddAnswerChoiceYn;
    private List<VoteQuestionChoice> questionChoiceList;

    public QuestionEntity toEntity() {
        return QuestionEntity.builder()
                .id(new QuestionEntityId(voteId, questionId))
                .questionContent(questionContent)
                .questionType(questionType)
                .canAddAnswerChoiceYn(canAddAnswerChoiceYn)
                .build();
    }
}
