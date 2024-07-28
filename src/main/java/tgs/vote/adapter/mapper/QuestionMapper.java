package tgs.vote.adapter.mapper;

import org.mapstruct.Mapper;
import tgs.vote.adapter.out.model.persistence.vote.QuestionEntity;
import tgs.vote.domain.vote.Question;

@Mapper
public interface QuestionMapper {

    Question toQuestion(QuestionEntity entity);

    QuestionEntity toQuestionEntity(Question question);
}
