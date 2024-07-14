package tgs.vote.adapter.out.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tgs.vote.adapter.out.model.vote.VoteEntity;
import tgs.vote.domain.vote.VoteDetail;

/**
 *  투표 Mapper
 */
@Mapper(componentModel = "spring")
public interface VoteMapper {
    @Mapping(target = "questionList", ignore = true) // questionList 필드를 무시함
    VoteDetail voteEntityToVoteDetail(VoteEntity vote);
}
