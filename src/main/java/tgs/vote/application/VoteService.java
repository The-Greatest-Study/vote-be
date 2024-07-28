package tgs.vote.application;

import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tgs.vote.application.in.CreateVoteUseCase;
import tgs.vote.application.in.GetVoteListUseCase;
import tgs.vote.application.model.vote.CreateVoteInCommand;
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
        /* 2024.07.28 (일) 도메인과 관련하여 고민중인 부분
         * Vote라는 도메인은 어차피 Question, Choice에 대한 부분을 다 가지고 있기 때문에
         * 저장/수정 로직을 탈때 어차피 Vote -> Question -> Choice를 다 저장/수정해야함
         *
         * 그러면 이 로직이 Service가 아니라 VoteAdapter에 있어야 하는건 아닐까?
         * (스마게에서는 그런 방식으로 코딩이 되어 있긴 함)
         *
         * 근데 또 뭔가 바깥 레이어에서 그렇게 로직을 가지고 있다는게 좀 이상한것 같음...
         * 이 Service 내에 있어야 할 것 같은데...
         * (이런 방식 또한 스마게 내에 존재하고 있음)
         * */
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
