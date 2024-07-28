package tgs.vote.adapter.out;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import tgs.vote.adapter.mapper.QuestionMapper;
import tgs.vote.adapter.out.impl.QuestionJpaRepository;
import tgs.vote.adapter.out.model.persistence.vote.QuestionEntity;
import tgs.vote.application.out.QuestionPort;
import tgs.vote.domain.vote.Question;

@RequiredArgsConstructor
@Repository
public class QuestionPersistenceAdapter implements QuestionPort {
    private final QuestionJpaRepository questionJpaRepository;
    private final QuestionMapper questionMapper;

    @Override
    public Question save(Question question) {
        QuestionEntity entity = questionMapper.toQuestionEntity(question);

        QuestionEntity savedEntity = questionJpaRepository.save(entity);

        return questionMapper.toQuestion(savedEntity);
    }
}
