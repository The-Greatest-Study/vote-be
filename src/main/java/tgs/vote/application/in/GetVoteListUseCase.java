package tgs.vote.application.in;

import java.util.List;
import tgs.vote.domain.vote.Vote;

public interface GetVoteListUseCase {
    List<Vote> getVoteList();
}
