package tgs.vote.adapter.out;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tgs.vote.adapter.out.mapper.QuestionMapper;
import tgs.vote.adapter.out.model.question.QuestionEntity;
import tgs.vote.application.out.QuestionPort;
import tgs.vote.domain.vote.VoteDetailQuestion;

import java.util.List;

@Component
@RequiredArgsConstructor
public class QuestionPersistaenceAdapter implements QuestionPort {

    private final QuestionJpaRepository questionJpaRepository;
    private final QuestionMapper questionMapper;

    @Override
    public List<VoteDetailQuestion> findQuestionListByVoteId(Long voteId) {
        List<QuestionEntity> questionEntityList = questionJpaRepository.findByVoteId(voteId);
        return questionMapper.questionEntityListToVoteDetailQuestionList(questionEntityList);
    }

}
