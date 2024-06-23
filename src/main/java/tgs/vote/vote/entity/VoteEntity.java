package tgs.vote.vote.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity(name = "tb_vote")
public class VoteEntity {
    @Id private Long voteId;
    private String voteTitle;
    private String voteDescription;
    private String voteThumbnail;
    private String voteCreator;
    private String voteOpenStatus;
    private String voteAnonymousAvailableYn;
    private String voteInProcessResultOpenStatus;
    private String voteEndResultOpenStatus;
    private String voteAgainAvailableYn;
    private LocalDateTime voteCreateDatetime;
    private LocalDateTime voteStartDatetime;
    private LocalDateTime voteEndDatetime;
}
