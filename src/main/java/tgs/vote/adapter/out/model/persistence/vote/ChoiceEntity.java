package tgs.vote.adapter.out.model.persistence.vote;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
@Entity(name = "tb_choice")
public class ChoiceEntity {

    @EmbeddedId private ChoiceEntityId id;
    private String choiceContent;
}
