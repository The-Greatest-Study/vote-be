package tgs.vote.adapter.out.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import tgs.vote.adapter.model.vote.QuestionEntity;

public interface QuestionJpaRepository extends JpaRepository<QuestionEntity, Long> {}
