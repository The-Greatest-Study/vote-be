package tgs.vote.adapter.out.model.web;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Builder(access = AccessLevel.PRIVATE)
@Getter
public class VoteCreateResponse {
    private Long voteId;

    public static VoteCreateResponse from(Long voteId) {
        return VoteCreateResponse.builder().voteId(voteId).build();
    }
}
