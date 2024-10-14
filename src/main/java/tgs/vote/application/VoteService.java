package tgs.vote.application;

import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import tgs.vote.application.in.CreateDoVoteUseCase;
import tgs.vote.application.in.CreateVoteUseCase;
import tgs.vote.application.in.GetVoteListUseCase;
import tgs.vote.application.model.vote.CreateDoVoteInCommand;
import tgs.vote.application.model.vote.CreateVoteInCommand;
import tgs.vote.application.out.VotePort;
import tgs.vote.domain.vote.Choice;
import tgs.vote.domain.vote.Question;
import tgs.vote.domain.vote.Vote;

@RequiredArgsConstructor
@Service
public class VoteService implements GetVoteListUseCase, CreateVoteUseCase, CreateDoVoteUseCase {
    private final VotePort votePort;

    public List<Vote> getVoteList() {
        return votePort.getVoteListByCreatorId(1L);
    }

    @Transactional
    @Override
    public Long createVote(CreateVoteInCommand command) {
        Vote savedVote = votePort.save(command.vote());

        return savedVote.getVoteId();
    }

    @Transactional
    @Override
    public Long createDoVote(CreateDoVoteInCommand command) {
        Vote vote = votePort.getVoteByVoteId(command.vote().getVoteId());

        /** Data 확인 **/
        System.out.println("vote 부속정보:");
        System.out.println("QuestionList:");
        for (Question q : vote.getQuestionList()) {
            System.out.println(q.toString());
            System.out.println("AnswerList:");
            if(q.getQuestionChoiceList().size() < 1) {
                System.out.println("답변작성 없음");
            } else {
                for (Choice choice : q.getQuestionChoiceList()) {
                    System.out.println(choice.toString());
                }
            }
        }
        System.out.println(vote.getQuestionList().toString());
        

        vote.setQuestionList(command.questionList());
        Vote savedVote = votePort.save(vote);
        return savedVote.getVoteId();
    }
}
