package tgs.vote.adapter.model.vote;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Getter;
import tgs.vote.adapter.model.BaseEntity;

@Getter
@Entity(name = "tb_vote")
public class VoteEntity extends BaseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long voteId;

    private String title;
    private String description;
    private String thumbnail;
    private Long voteCreator;
    private String accessLevel;
    private String anonymousAvailableYn;
    private String inprogressResultOpenStatus;
    private String endResultOpenStatus;
    private String revoteAvailableYn;
    private LocalDateTime createDatetime;
    private LocalDateTime startDatetime;
    private LocalDateTime endDatetime;
}
