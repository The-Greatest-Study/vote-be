package tgs.vote.adapter.model.vote;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import tgs.vote.adapter.model.BaseEntity;

@Getter
@Entity(name = "Comment")
@Table(name = "tb_comment")
public class CommentEntity extends BaseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long commentId;

    private String comment;
    private Long userId;
    private Long voteId;
}
