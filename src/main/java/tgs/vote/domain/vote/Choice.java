package tgs.vote.domain.vote;

import lombok.Data;

@Data
public class Choice {
    private Long questionId;
    private Long choiceId;
    private String choiceContent;
}
