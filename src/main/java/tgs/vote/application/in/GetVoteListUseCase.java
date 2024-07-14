package tgs.vote.application.in;

import java.util.List;
import tgs.vote.domain.vote.Vote;
import tgs.vote.domain.vote.VoteDetail;

public interface GetVoteListUseCase {
    List<Vote> getVoteList();
    VoteDetail getVoteDetail(Long voteId);
}
