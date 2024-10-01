package tgs.vote.adapter.model.vote;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import tgs.vote.adapter.model.BaseEntity;

@Getter
@Entity(name = "Choice")
@Table(name = "tb_choice")
public class ChoiceEntity extends BaseEntity {
    @Id private Long choiceId;
    private Long questionId;
    private String choiceContent;
}
