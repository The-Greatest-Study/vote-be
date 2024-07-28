package tgs.vote.adapter.out;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tgs.vote.adapter.mapper.VoteMapper;
import tgs.vote.adapter.model.persistence.vote.VoteEntity;
import tgs.vote.adapter.out.persistance.VoteJpaRepository;
import tgs.vote.application.out.VotePort;
import tgs.vote.domain.vote.Vote;

@Component
@RequiredArgsConstructor
public class VoteAdapter implements VotePort {
    private final VoteJpaRepository voteJpaRepository;
    private final VoteMapper voteMapper;

    @Override
    public Vote save(Vote vote) {
        VoteEntity entity = voteMapper.toVoteEntity(vote);

        VoteEntity savedEntity = voteJpaRepository.save(entity);

        return voteMapper.toVote(savedEntity);
    }

    @Override
    public List<Vote> getVoteListByCreatorId(Long creatorId) {
        List<VoteEntity> voteEntityList = voteJpaRepository.findByVoteCreator(creatorId);

        return voteMapper.toVotes(voteEntityList);
    }
}
