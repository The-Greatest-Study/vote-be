package tgs.vote.domain.vote;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
public class VoteDetail {
    //TODO field 정규화 필요

    // Vote
    private Long voteId;
    private String voteTitle;
    private String voteDescription;
    private String voteOpenStatus;
    private String voteAnonymousAvailableYn;
    private String voteInProcessResultOpenStatus;
    private String voteEndResultOpenStatus;
    private String voteAgainAvailableYn;
    private LocalDateTime voteStartDatetime;
    private LocalDateTime voteEndDatetime;

    // Question
    private List<VoteDetailQuestion> questionList;

    public void updateQuestions(List<VoteDetailQuestion> questionList) {
        this.questionList = questionList;
    }
}
