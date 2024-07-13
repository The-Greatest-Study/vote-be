package tgs.vote.domain.vote.model;

import lombok.Getter;

@Getter
public class VoteQuestion {
    private Long questionId;
    private Long voteId;
    private String questionContent;
    private String questionType;
}
