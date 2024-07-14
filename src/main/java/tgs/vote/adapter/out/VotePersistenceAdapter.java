package tgs.vote.adapter.out;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tgs.vote.adapter.out.model.vote.VoteEntity;
import tgs.vote.application.out.VotePort;
import tgs.vote.common.exception.VoteNotFoundException;
import tgs.vote.domain.vote.Vote;
import tgs.vote.adapter.out.mapper.VoteMapper;
import tgs.vote.domain.vote.VoteDetail;

@Component
@RequiredArgsConstructor
public class VotePersistenceAdapter implements VotePort {
    private final VoteJpaRepository voteJpaRepository;

    private final VoteMapper voteMapper;

    @Override
    public List<Vote> getVoteListByCreatorId(Long creatorId) {
        List<VoteEntity> voteEntityList = voteJpaRepository.findByVoteCreator(creatorId);
        return voteEntityList.stream().map(VoteEntity::toDomainEntity).toList();
    }

    @Override
    public VoteDetail findVoteDetail(Long voteId) {
        VoteEntity voteEntity = voteJpaRepository.findByVoteId(voteId);

        if (voteEntity == null) {
            throw new VoteNotFoundException(voteId);
        }

        return voteMapper.voteEntityToVoteDetail(voteEntity);
    }
}
