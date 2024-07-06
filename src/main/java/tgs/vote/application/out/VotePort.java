package tgs.vote.application.out;

import java.util.List;
import tgs.vote.domain.vote.Vote;

public interface VotePort {
    List<Vote> getVoteListByCreatorId(Long creatorId);
}
