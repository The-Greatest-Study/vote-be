package tgs.vote.adapter.out.model.question;

import jakarta.persistence.*;
import lombok.Getter;
import tgs.vote.adapter.out.model.BaseEntity;
import tgs.vote.domain.question.QuestionType;

@Getter
@Entity(name = "tb_question")
public class QuestionEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;
    private Long voteId;
    private String questionContent;
    @Enumerated(EnumType.STRING)
    private QuestionType questionType;
    private String canAddChoiceYn;

}
