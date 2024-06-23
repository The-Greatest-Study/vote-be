package tgs.vote.vote.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Getter;

@Getter
@Entity(name = "tb_answer_choice")
public class AnswerChoiceEntity {

    @EmbeddedId private AnswerChoiceEntityId id;
    private String answerChoice;
}
