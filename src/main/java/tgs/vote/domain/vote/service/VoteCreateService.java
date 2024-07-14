package tgs.vote.domain.vote.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tgs.vote.adapter.in.model.VoteCreateRequest;
import tgs.vote.adapter.out.model.persistence.vote.VoteEntity;
import tgs.vote.application.in.CreateVoteUseCase;
import tgs.vote.domain.vote.model.VoteQuestion;
import tgs.vote.domain.vote.model.VoteQuestionChoice;
import tgs.vote.adapter.out.repository.ChoiceRepository;
import tgs.vote.adapter.out.repository.QuestionRepository;
import tgs.vote.adapter.out.repository.VoteRepository;

@RequiredArgsConstructor
@Service
public class VoteCreateService implements CreateVoteUseCase {
    VoteRepository voteRepository;
    QuestionRepository questionRepository;
    ChoiceRepository choiceRepository;

    @Override
    public Long createVote(VoteCreateRequest voteCreateRequest) {
        Long newVoteId = voteRepository.findMaxId();
        VoteEntity voteEntity = voteCreateRequest.toVoteEntity(newVoteId);
        voteRepository.save(voteEntity);

        for (VoteQuestion question : voteCreateRequest.getVoteQuestionList()) {
            questionRepository.save(question.toEntity());
            for (VoteQuestionChoice choice : question.getQuestionChoiceList()) {
                choiceRepository.save(choice.toEntity());
            }
        }
        return newVoteId;
    }
}
