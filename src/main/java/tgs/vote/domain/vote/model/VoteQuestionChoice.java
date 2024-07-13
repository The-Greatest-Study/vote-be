package tgs.vote.domain.vote.model;

import lombok.Getter;

@Getter
public class VoteQuestionChoice {
    private Long choiceId;
    private Long questionId;
    private String choiceContent;
}
