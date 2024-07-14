package tgs.vote.adapter.in.model;

import lombok.Getter;
import tgs.vote.adapter.out.model.persistence.vote.VoteEntity;
import tgs.vote.domain.vote.model.VoteQuestion;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class VoteCreateRequest {
    private String voteTitle;
    private String voteDescription;
    private String voteThumbnail;
    private Long voteCreator;
    private String voteOpenStatus;
    private String voteAnonymousAvailableYn;
    private String voteInProcessResultOpenStatus;
    private String voteEndResultOpenStatus;
    private String voteAgainAvailableYn;
    private LocalDateTime voteCreateDatetime;
    private LocalDateTime voteStartDatetime;
    private LocalDateTime voteEndDatetime;

    List<VoteQuestion> voteQuestionList;

    public VoteEntity toVoteEntity(Long voteId) {
        return VoteEntity.builder()
                .voteId(voteId)
                .voteTitle(voteTitle)
                .voteDescription(voteDescription)
                .voteThumbnail(voteThumbnail)
                .voteCreator(voteCreator)
                .voteOpenStatus(voteOpenStatus)
                .voteAnonymousAvailableYn(voteAnonymousAvailableYn)
                .voteInProcessResultOpenStatus(voteInProcessResultOpenStatus)
                .voteEndResultOpenStatus(voteEndResultOpenStatus)
                .voteAgainAvailableYn(voteAgainAvailableYn)
                .voteCreateDatetime(voteCreateDatetime)
                .voteStartDatetime(voteStartDatetime)
                .voteEndDatetime(voteEndDatetime)
                .build();
    }
}
