package tgs.vote.adapter.out.model.answerChoice;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import tgs.vote.adapter.out.model.BaseEntity;

@Getter
@Entity(name = "tb_answer_choice")
public class AnswerChoiceEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerChoiceId;
    private Long voteId;
    private Long questionId;
    private String answerChoice;

}
