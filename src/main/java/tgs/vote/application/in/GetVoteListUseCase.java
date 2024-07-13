package tgs.vote.application.in;

import java.util.List;
import tgs.vote.domain.vote.model.Vote;

public interface GetVoteListUseCase {
    List<Vote> getVoteList();
}
