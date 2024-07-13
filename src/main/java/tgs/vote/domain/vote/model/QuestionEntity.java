package tgs.vote.domain.vote.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import tgs.vote.domain.vote.enums.QuestionType;

@Getter
@Entity(name = "tb_question")
public class QuestionEntity {
    @EmbeddedId private QuestionEntityId id;
    private String question;
    private QuestionType questionType;
    private String canAddAnswerChoiceYn;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChoiceEntity> answerChoices = new ArrayList<>();
}
