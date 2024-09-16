package tgs.vote.application;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tgs.vote.application.in.CreateVoteUseCase;
import tgs.vote.application.in.GetVotesUseCase;
import tgs.vote.application.model.vote.CreateVoteInCommand;
import tgs.vote.application.model.vote.GetVotesCommand;
import tgs.vote.application.model.vote.GetVotesResult;
import tgs.vote.application.out.VotePort;
import tgs.vote.domain.vote.Vote;

@RequiredArgsConstructor
@Service
public class VoteService implements CreateVoteUseCase, GetVotesUseCase {
    private final VotePort votePort;

    @Transactional
    @Override
    public Long createVote(CreateVoteInCommand command) {
        Vote savedVote = votePort.save(command.vote());

        return savedVote.getVoteId();
    }

    @Transactional(readOnly = true)
    @Override
    public List<GetVotesResult> getVotesBy(GetVotesCommand command) {
        return votePort.findVotesBy(command);
    }
}
