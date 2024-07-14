package tgs.vote.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tgs.vote.adapter.out.model.question.QuestionEntity;

import java.util.List;

@Repository
public interface QuestionJpaRepository extends JpaRepository<QuestionEntity, Long> {
    List<QuestionEntity> findByVoteId(long voteId);
}
