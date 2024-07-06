package tgs.vote.application;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tgs.vote.application.in.GetVoteListUseCase;
import tgs.vote.application.out.VotePort;
import tgs.vote.domain.vote.Vote;

@RequiredArgsConstructor
@Service
public class VoteService implements GetVoteListUseCase {
    private final VotePort votePort;

    public List<Vote> getVoteList() {
        return votePort.getVoteListByCreatorId(1L);
    }
}
