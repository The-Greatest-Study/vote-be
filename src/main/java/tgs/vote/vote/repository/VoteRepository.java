package tgs.vote.vote.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tgs.vote.vote.entity.VoteEntity;

@Repository
public interface VoteRepository extends JpaRepository<VoteEntity, Long> {
    List<VoteEntity> findByVoteCreator(String voteCreator);
}
