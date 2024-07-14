package tgs.vote.adapter.out.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tgs.vote.adapter.out.model.persistence.vote.QuestionEntity;
import tgs.vote.adapter.out.model.persistence.vote.QuestionEntityId;

public interface QuestionRepository extends JpaRepository<QuestionEntity, QuestionEntityId> {
}
