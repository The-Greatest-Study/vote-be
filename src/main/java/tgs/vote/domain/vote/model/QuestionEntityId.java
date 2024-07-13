package tgs.vote.domain.vote.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class QuestionEntityId implements Serializable {
    private Long voteId;
    private Long questionId;
}
