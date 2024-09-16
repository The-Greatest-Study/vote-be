package tgs.vote.application.out;

import java.util.List;
import tgs.vote.application.model.vote.GetVotesCommand;
import tgs.vote.application.model.vote.GetVotesResult;
import tgs.vote.domain.vote.Vote;

public interface VotePort {
    Vote save(Vote vote);

    List<GetVotesResult> findVotesBy(GetVotesCommand command);
}
