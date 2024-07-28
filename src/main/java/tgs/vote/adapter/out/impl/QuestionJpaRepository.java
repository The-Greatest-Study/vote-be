package tgs.vote.adapter.out.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import tgs.vote.adapter.out.model.persistence.vote.QuestionEntity;

public interface QuestionJpaRepository extends JpaRepository<QuestionEntity, Long> {}
