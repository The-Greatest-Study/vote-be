package tgs.vote.adapter.out;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tgs.vote.adapter.mapper.ChoiceMapper;
import tgs.vote.adapter.mapper.QuestionMapper;
import tgs.vote.adapter.mapper.VoteMapper;
import tgs.vote.adapter.model.vote.ChoiceEntity;
import tgs.vote.adapter.model.vote.QuestionEntity;
import tgs.vote.adapter.model.vote.VoteEntity;
import tgs.vote.adapter.out.persistance.ChoiceJpaRepository;
import tgs.vote.adapter.out.persistance.QuestionJpaRepository;
import tgs.vote.adapter.out.persistance.VoteJpaRepository;
import tgs.vote.application.out.VotePort;
import tgs.vote.domain.vote.Choice;
import tgs.vote.domain.vote.Question;
import tgs.vote.domain.vote.Vote;

@Component
@RequiredArgsConstructor
public class VoteAdapter implements VotePort {
    private final VoteJpaRepository voteJpaRepository;
    private final QuestionJpaRepository questionJpaRepository;
    private final ChoiceJpaRepository choiceJpaRepository;
    private final VoteMapper voteMapper;
    private final QuestionMapper questionMapper;
    private final ChoiceMapper choiceMapper;

    @Override
    public Vote save(Vote vote) {
        VoteEntity voteEntity = voteMapper.toVoteEntity(vote);

        VoteEntity savedVoteEntity = voteJpaRepository.save(voteEntity);

        for (Question question : vote.getQuestionList()) {
            question.setVoteId(savedVoteEntity.getVoteId());
            QuestionEntity questionEntity = questionMapper.toQuestionEntity(question);
            QuestionEntity savedQuestionEntity = questionJpaRepository.save(questionEntity);

            for (Choice choice : question.getQuestionChoiceList()) {
                choice.setQuestionId(savedQuestionEntity.getQuestionId());
                ChoiceEntity choiceEntity = choiceMapper.toChoiceEntity(choice);
                choiceJpaRepository.save(choiceEntity);
            }
        }

        return voteMapper.toVote(savedVoteEntity);
    }

    @Override
    public List<Vote> getVoteListByCreatorId(Long creatorId) {
        List<VoteEntity> voteEntityList = voteJpaRepository.findByCreator(creatorId);

        return voteMapper.toVotes(voteEntityList);
    }
}
