package tgs.vote.application.out;

import java.util.List;
import tgs.vote.domain.vote.Vote;

public interface VotePort {
    Vote save(Vote vote);

    List<Vote> getVoteListByCreatorId(Long creatorId);
}
