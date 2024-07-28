package tgs.vote.adapter.out.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import tgs.vote.adapter.model.persistence.vote.ChoiceEntity;

public interface ChoiceJpaRepository extends JpaRepository<ChoiceEntity, Long> {}
