package tgs.vote.adapter.model.vote;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import tgs.vote.adapter.model.BaseEntity;
import tgs.vote.adapter.model.user.UserEntity;

@Getter
@Entity(name = "Vote")
@Table(name = "tb_vote")
public class VoteEntity extends BaseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long voteId;

    private String title;
    private String description;
    private String thumbnail;

    @ManyToOne
    @JoinColumn(name = "creator")
    private UserEntity creator;

    private String accessLevel;
    private String anonymousAvailableYn;
    private String inprogressResultOpenStatus;
    private String endResultOpenStatus;
    private String revoteAvailableYn;
    private LocalDateTime createDatetime;
    private LocalDateTime startDatetime;
    private LocalDateTime endDatetime;
}
