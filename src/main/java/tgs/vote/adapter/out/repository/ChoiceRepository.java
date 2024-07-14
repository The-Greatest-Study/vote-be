package tgs.vote.adapter.out.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tgs.vote.adapter.out.model.persistence.vote.ChoiceEntity;
import tgs.vote.adapter.out.model.persistence.vote.ChoiceEntityId;

public interface ChoiceRepository extends JpaRepository<ChoiceEntity, ChoiceEntityId> {
}
