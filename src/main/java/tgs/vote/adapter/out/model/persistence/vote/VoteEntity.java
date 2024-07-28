package tgs.vote.adapter.out.model.persistence.vote;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Data;

@Data
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
}
