package tgs.vote.adapter.out.model.persistence.vote;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class ChoiceEntityId implements Serializable {
    private Long questionId;
    private Long choiceId;
}
