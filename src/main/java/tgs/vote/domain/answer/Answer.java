package tgs.vote.domain.answer;

import lombok.Getter;

@Getter
public class Answer {
    private Long answerId;
    private Long questionId;
    private Long userId;
    private String answerContent;
    private Long choiceId;
}
