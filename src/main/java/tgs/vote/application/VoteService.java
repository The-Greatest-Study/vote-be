package tgs.vote.application;

import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tgs.vote.application.in.CreateVoteInCommand;
import tgs.vote.application.in.CreateVoteUseCase;
import tgs.vote.application.in.GetVoteListUseCase;
import tgs.vote.application.out.ChoicePort;
import tgs.vote.application.out.QuestionPort;
import tgs.vote.application.out.VotePort;
import tgs.vote.domain.vote.Choice;
import tgs.vote.domain.vote.Question;
import tgs.vote.domain.vote.Vote;

@RequiredArgsConstructor
@Service
public class VoteService implements GetVoteListUseCase, CreateVoteUseCase {
    private final VotePort votePort;
    private final QuestionPort questionPort;
    private final ChoicePort choicePort;

    public List<Vote> getVoteList() {
        return votePort.getVoteListByCreatorId(1L);
    }

    @Transactional
    @Override
    public Long createVote(CreateVoteInCommand command) {
        Vote savedVote = votePort.save(command.vote());

        for (Question question : command.questionList()) {
            question.setVoteId(savedVote.getVoteId());
            Question savedQuestion = questionPort.save(question);
            for (Choice choice : question.getQuestionChoiceList()) {
                choice.setQuestionId(savedQuestion.getQuestionId());
                choicePort.save(choice);
            }
        }

        return savedVote.getVoteId();
    }
}
