package tgs.vote.application.out;

import java.util.List;
import tgs.vote.domain.vote.model.Vote;

public interface VotePort {
    List<Vote> getVoteListByCreatorId(Long creatorId);
}
