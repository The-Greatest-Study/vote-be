package tgs.vote.adapter.out.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tgs.vote.adapter.out.model.persistence.vote.VoteEntity;

@Repository
public interface VoteRepository extends JpaRepository<VoteEntity, Long> {

    @Query(value = "SELECT MAX(vote_id) FROM tb_vote", nativeQuery = true)
    Long findMaxId();


}
