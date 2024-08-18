package tgs.vote.adapter.mapper;

import org.mapstruct.Mapper;
import tgs.vote.adapter.model.vote.ChoiceEntity;
import tgs.vote.domain.vote.Choice;

@Mapper
public interface ChoiceMapper {

    Choice toChoice(ChoiceEntity entity);

    ChoiceEntity toChoiceEntity(Choice choice);
}
