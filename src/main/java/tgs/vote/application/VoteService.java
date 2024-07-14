package tgs.vote.application;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tgs.vote.application.in.GetVoteListUseCase;
import tgs.vote.application.out.QuestionPort;
import tgs.vote.application.out.VotePort;
import tgs.vote.domain.vote.Vote;
import tgs.vote.domain.vote.VoteDetail;
import tgs.vote.domain.vote.VoteDetailQuestion;

@RequiredArgsConstructor
@Service
public class VoteService implements GetVoteListUseCase {
    private final VotePort votePort;
    private final QuestionPort questionPort;

    public List<Vote> getVoteList() {
        return votePort.getVoteListByCreatorId(1L);
    }

    @Override
    public VoteDetail getVoteDetail(Long voteId) {
        VoteDetail voteDetail = votePort.findVoteDetail(voteId);

        List<VoteDetailQuestion> questionList = questionPort.findQuestionListByVoteId(voteId);

        if(CollectionUtils.isEmpty(questionList)) {
            return voteDetail;
        }

        voteDetail.updateQuestions(questionList);

        return voteDetail;
    }
}
