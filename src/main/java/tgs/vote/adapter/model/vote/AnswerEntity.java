package tgs.vote.adapter.model.vote;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import tgs.vote.adapter.model.BaseEntity;

@Getter
@Entity(name = "tb_answer")
public class AnswerEntity extends BaseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long answerId;

    private String content;
    private Long questionId;
    private Long userId;
    private Long choiceId;
}
