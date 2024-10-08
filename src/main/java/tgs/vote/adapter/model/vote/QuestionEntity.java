package tgs.vote.adapter.model.vote;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import tgs.vote.adapter.model.BaseEntity;
import tgs.vote.domain.vote.enums.QuestionType;

@Getter
@Entity(name = "tb_question")
public class QuestionEntity extends BaseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long questionId;

    private String content;
    private QuestionType questionType;
    private String canAddAnswerChoiceYn;
    private Long voteId;
}
