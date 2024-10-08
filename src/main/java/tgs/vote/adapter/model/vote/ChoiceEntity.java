package tgs.vote.adapter.model.vote;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import tgs.vote.adapter.model.BaseEntity;

@Data
@Entity(name = "tb_choice")
public class ChoiceEntity extends BaseEntity {
    @Id private Long choiceId;
    private Long questionId;
    private String choiceContent;
}
