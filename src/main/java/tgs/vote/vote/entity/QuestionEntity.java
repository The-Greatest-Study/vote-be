package tgs.vote.vote.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import tgs.vote.vote.enums.QuestionType;

@Getter
@Entity(name = "tb_question")
public class QuestionEntity {
    @EmbeddedId private QuestionEntityId id;
    private String question;
    private QuestionType questionType;
    private String canAddAnswerChoiceYn;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AnswerChoiceEntity> answerChoices = new ArrayList<>();
}
