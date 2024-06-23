package tgs.vote.vote.entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class AnswerChoiceEntityId implements Serializable {
    private Long voteId;
    private Long questionId;
    private Long answerChoiceId;
}
