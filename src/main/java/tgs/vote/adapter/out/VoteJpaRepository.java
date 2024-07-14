package tgs.vote.adapter.out;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tgs.vote.adapter.out.model.vote.VoteEntity;

@Repository
public interface VoteJpaRepository extends JpaRepository<VoteEntity, Long> {
    List<VoteEntity> findByVoteCreator(long voteCreator);
    VoteEntity findByVoteId(long voteId);
}
