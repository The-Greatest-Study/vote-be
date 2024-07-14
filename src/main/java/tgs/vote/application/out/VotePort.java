package tgs.vote.application.out;

import java.util.List;
import tgs.vote.domain.vote.Vote;
import tgs.vote.domain.vote.VoteDetail;

public interface VotePort {

    List<Vote> getVoteListByCreatorId(Long creatorId);

    VoteDetail findVoteDetail(Long voteId);

}
