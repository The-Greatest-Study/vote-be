package tgs.vote.adapter.model.vote;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Data;
import tgs.vote.adapter.model.BaseEntity;
import tgs.vote.domain.vote.enums.QuestionType;

@Data
@Entity(name = "tb_question")
public class QuestionEntity extends BaseEntity {
    @Id private Long questionId;
    private Long voteId;
    private String questionContent;
    @Enumerated(EnumType.STRING)
    private QuestionType questionType;
    private String canAddChoiceYn;
}
