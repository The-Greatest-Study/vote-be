package tgs.vote.adapter.out.model.persistence.vote;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import tgs.vote.domain.vote.enums.QuestionType;

@Getter
@Builder
@RequiredArgsConstructor
@Entity(name = "tb_question")
public class QuestionEntity {
    @EmbeddedId private QuestionEntityId id;
    private String questionContent;
    private QuestionType questionType;
    private String canAddAnswerChoiceYn;

//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<ChoiceEntity> questionChoiceList = new ArrayList<>();
}
