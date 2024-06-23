package tgs.vote.vote.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<QuestionEntity> questions = new ArrayList<>();
}
