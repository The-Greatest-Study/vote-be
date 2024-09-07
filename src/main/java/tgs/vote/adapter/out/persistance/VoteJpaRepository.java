package tgs.vote.adapter.out.persistance;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tgs.vote.adapter.model.vote.VoteEntity;

@Repository
public interface VoteJpaRepository extends JpaRepository<VoteEntity, Long>, VoteCustomJpaRepository {
    List<VoteEntity> findByVoteCreator(long voteCreator);

    @Query(value = "SELECT MAX(vote_id) FROM tb_vote", nativeQuery = true)
    Long findMaxId();

    VoteEntity findByVoteId(long voteId);
}
