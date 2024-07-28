package tgs.vote.adapter.out;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import tgs.vote.adapter.mapper.ChoiceMapper;
import tgs.vote.adapter.model.persistence.vote.ChoiceEntity;
import tgs.vote.adapter.out.persistance.ChoiceJpaRepository;
import tgs.vote.application.out.ChoicePort;
import tgs.vote.domain.vote.Choice;

@RequiredArgsConstructor
@Repository
public class ChoiceAdapter implements ChoicePort {
    private final ChoiceJpaRepository choiceJpaRepository;
    private final ChoiceMapper choiceMapper;

    @Override
    public Choice save(Choice choice) {
        ChoiceEntity entity = choiceMapper.toChoiceEntity(choice);

        ChoiceEntity savedEntity = choiceJpaRepository.save(entity);

        return choiceMapper.toChoice(savedEntity);
    }
}
