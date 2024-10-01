package tgs.vote.adapter.out.persistance;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tgs.vote.adapter.model.vote.VoteEntity;
import tgs.vote.application.model.vote.GetVotesResult;

@Repository
public interface VoteJpaRepository extends JpaRepository<VoteEntity, Long> {

    @Query(
            "SELECT new tgs.vote.application.model.vote.GetVotesResult(v.voteId"
                    + ", v.title"
                    + ", v.creator.userId"
                    + ", u.name"
                    + ", v.thumbnail"
                    + ", v.startDatetime"
                    + ", v.endDatetime"
                    + ", (SELECT COUNT(a) FROM Question q LEFT JOIN q.answers a WHERE q.vote.voteId = v.voteId)"
                    + ", (CASE WHEN CURRENT_DATE BETWEEN v.startDatetime AND v.endDatetime THEN true ELSE false END)) "
                    + "FROM Vote v "
                    + "JOIN User u ON v.creator = u "
                    + "ORDER BY v.startDatetime DESC")
    List<GetVotesResult> findVotesWithCount();
}
