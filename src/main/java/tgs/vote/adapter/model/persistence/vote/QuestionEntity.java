package tgs.vote.adapter.model.persistence.vote;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import tgs.vote.adapter.model.persistence.BaseEntity;
import tgs.vote.domain.vote.enums.QuestionType;

@Data
@Entity(name = "tb_question")
public class QuestionEntity extends BaseEntity {
    @Id private Long questionId;
    private Long voteId;
    private String questionContent;
    private QuestionType questionType;
    private String canAddAnswerChoiceYn;
}
