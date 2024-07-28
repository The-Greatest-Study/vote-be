package tgs.vote.adapter.out.model.persistence.vote;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "tb_choice")
public class ChoiceEntity {
    @Id private Long choiceId;
    private Long questionId;
    private String choiceContent;
}
