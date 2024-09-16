package tgs.vote.adapter.mapper;

import java.util.List;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import tgs.vote.adapter.model.vote.SearchVotesResponse;
import tgs.vote.adapter.model.vote.VoteCreateRequest;
import tgs.vote.adapter.model.vote.VoteEntity;
import tgs.vote.application.model.vote.CreateVoteInCommand;
import tgs.vote.application.model.vote.GetVotesResult;
import tgs.vote.domain.vote.Vote;

@Mapper
public interface VoteMapper {

    @Named("toVote")
    Vote toVote(VoteEntity entity);

    @IterableMapping(qualifiedByName = "toVote")
    List<Vote> toVotes(List<VoteEntity> entities);

    VoteEntity toVoteEntity(Vote vote);

    @Mapping(target = "vote.voteTitle", source = "voteTitle")
    @Mapping(target = "vote.voteDescription", source = "voteDescription")
    @Mapping(target = "vote.voteThumbnail", source = "voteThumbnail")
    @Mapping(target = "vote.voteCreator", source = "voteCreator")
    @Mapping(target = "vote.voteOpenStatus", source = "voteOpenStatus")
    @Mapping(target = "vote.voteAnonymousAvailableYn", source = "voteAnonymousAvailableYn")
    @Mapping(
            target = "vote.voteInProcessResultOpenStatus",
            source = "voteInProcessResultOpenStatus")
    @Mapping(target = "vote.voteEndResultOpenStatus", source = "voteEndResultOpenStatus")
    @Mapping(target = "vote.voteAgainAvailableYn", source = "voteAgainAvailableYn")
    @Mapping(target = "vote.voteCreateDatetime", source = "voteCreateDatetime")
    @Mapping(target = "vote.voteStartDatetime", source = "voteStartDatetime")
    @Mapping(target = "vote.voteEndDatetime", source = "voteEndDatetime")
    CreateVoteInCommand toCreateVoteInCommand(VoteCreateRequest request);

    @Named("toSearchVotesResponse")
    SearchVotesResponse toSearchVotesResponse(GetVotesResult result);

    @IterableMapping(qualifiedByName = "toSearchVotesResponse")
    List<SearchVotesResponse> toSearchVotesResponses(List<GetVotesResult> results);
}
