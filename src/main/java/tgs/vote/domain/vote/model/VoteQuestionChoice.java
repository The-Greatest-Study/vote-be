package tgs.vote.domain.vote.model;

import lombok.Getter;
import tgs.vote.adapter.out.model.persistence.vote.ChoiceEntity;
import tgs.vote.adapter.out.model.persistence.vote.ChoiceEntityId;

@Getter
public class VoteQuestionChoice {
    private Long questionId;
    private Long choiceId;
    private String choiceContent;

    public ChoiceEntity toEntity() {
        return ChoiceEntity.builder()
                .id(new ChoiceEntityId(questionId, choiceId))
                .choiceContent(choiceContent)
                .build();
    }
}
