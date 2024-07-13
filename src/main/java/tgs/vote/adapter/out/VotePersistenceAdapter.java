package tgs.vote.adapter.out;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tgs.vote.adapter.out.model.vote.VoteEntity;
import tgs.vote.application.out.VotePort;
import tgs.vote.domain.vote.model.Vote;

@Component
@RequiredArgsConstructor
public class VotePersistenceAdapter implements VotePort {
    private final VoteJpaRepository voteJpaRepository;

    @Override
    public List<Vote> getVoteListByCreatorId(Long creatorId) {
        List<VoteEntity> voteEntityList = voteJpaRepository.findByVoteCreator(creatorId);
        return voteEntityList.stream().map(VoteEntity::toDomainEntity).toList();
    }
}
