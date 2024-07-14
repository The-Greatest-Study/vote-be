package tgs.vote.adapter.out.mapper;

import org.mapstruct.Mapper;
import tgs.vote.adapter.out.model.question.QuestionEntity;
import tgs.vote.domain.vote.VoteDetailQuestion;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    List<VoteDetailQuestion> questionEntityListToVoteDetailQuestionList(List<QuestionEntity> entityList);
}
