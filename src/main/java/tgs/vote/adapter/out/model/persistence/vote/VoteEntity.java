package tgs.vote.adapter.out.model.persistence.vote;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import tgs.vote.domain.vote.model.Vote;

@Getter
@Builder
@RequiredArgsConstructor
@Entity(name = "tb_vote")
public class VoteEntity {
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

    public Vote toDomainEntity() {
        return Vote.builder()
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
