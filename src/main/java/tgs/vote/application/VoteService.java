package tgs.vote.application;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tgs.vote.application.in.CreateVoteUseCase;
import tgs.vote.application.in.GetVoteListUseCase;
import tgs.vote.application.in.GetVoteUseCase;
import tgs.vote.application.model.vote.CreateVoteInCommand;
import tgs.vote.application.out.VotePort;
import tgs.vote.domain.vote.Vote;

@RequiredArgsConstructor
@Service
public class VoteService implements GetVoteUseCase, GetVoteListUseCase, CreateVoteUseCase {
    private final VotePort votePort;

    public List<Vote> getVoteList() {
        return votePort.getVoteListByCreatorId(1L);
    }

    @Transactional
    @Override
    public Long createVote(CreateVoteInCommand command) {
        Vote savedVote = votePort.save(command.vote());

        return savedVote.getVoteId();
    }

    @Transactional(readOnly = true)
    @Override
    public Vote getVoteDetail(Long id) {
        return votePort.getVoteDetail(id);
    }
}
