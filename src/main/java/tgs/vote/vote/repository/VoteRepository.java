package tgs.vote.vote.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tgs.vote.vote.entity.VoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository<VoteEntity, Long> {

    @Query("SELECT v FROM VoteEntity v WHERE :currentDate BETWEEN v.startDate AND v.endDate")
    List<VoteEntity> findOngoingVotes(@Param("currentDate") LocalDate currentDate);

}