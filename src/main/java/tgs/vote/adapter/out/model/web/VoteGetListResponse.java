package tgs.vote.adapter.out.model.web;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import tgs.vote.domain.vote.Vote;

@Builder(access = AccessLevel.PRIVATE)
@Getter
public class VoteGetListResponse {
    private long voteId;

    public static VoteGetListResponse from(Vote vote) {
        return VoteGetListResponse.builder().voteId(vote.getVoteId()).build();
    }
}
