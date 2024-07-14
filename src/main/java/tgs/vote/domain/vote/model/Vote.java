package tgs.vote.domain.vote.model;

import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import tgs.vote.adapter.out.model.persistence.vote.VoteEntity;

@Getter
@Builder
public class Vote {
    @Id private Long voteId;
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
    private List<VoteQuestion> voteQuestionList;

    public VoteEntity toEntity() {
        return VoteEntity.builder()
                .voteId(voteId)
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
