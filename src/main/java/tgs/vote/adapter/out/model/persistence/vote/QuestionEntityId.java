package tgs.vote.adapter.out.model.persistence.vote;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class QuestionEntityId implements Serializable {
    private Long voteId;
    private Long questionId;
}
