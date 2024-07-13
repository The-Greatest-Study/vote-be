package tgs.vote.adapter.out.model.question;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import tgs.vote.adapter.out.model.BaseEntity;

@Getter
@Entity(name = "tb_question")
public class QuestionEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;
    private Long voteId;
    private String question;
    private QuestionType questionType;
    private String canAddAnserChoiceYn;

}
