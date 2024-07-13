package tgs.vote.domain.vote.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Getter;

@Getter
@Entity(name = "tb_choice")
public class ChoiceEntity {

    @EmbeddedId private ChoiceEntityId id;
    private String answerChoice;
}
