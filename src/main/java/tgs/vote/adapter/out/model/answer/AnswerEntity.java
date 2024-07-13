package tgs.vote.adapter.out.model.answer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import tgs.vote.adapter.out.model.BaseEntity;

@Getter
@Entity(name = "tb_answer")
public class AnswerEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerId;
    private Long questionId;
    private Long answerChoiceId;
    private Long userId;
    private String answer;
}
