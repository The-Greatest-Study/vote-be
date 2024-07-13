package tgs.vote.adapter.out.model.vote;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Getter;
import tgs.vote.adapter.out.model.BaseEntity;
import tgs.vote.domain.vote.model.Vote;

@Getter
@Entity(name = "tb_vote")
public class VoteEntity extends BaseEntity {
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
