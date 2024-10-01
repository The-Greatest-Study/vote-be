package tgs.vote.adapter.model.vote;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;
import tgs.vote.adapter.model.BaseEntity;
import tgs.vote.domain.vote.enums.QuestionType;

@Getter
@Entity(name = "Question")
@Table(name = "tb_question")
public class QuestionEntity extends BaseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long questionId;

    private String content;
    private QuestionType questionType;
    private String canAddAnswerChoiceYn;

    @ManyToOne
    @JoinColumn(name = "vote_id", nullable = false)
    private VoteEntity vote;

    @OneToMany(mappedBy = "question")
    private List<AnswerEntity> answers;
}
