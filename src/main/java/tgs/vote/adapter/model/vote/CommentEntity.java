package tgs.vote.adapter.model.vote;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import tgs.vote.adapter.model.BaseEntity;

@Data
@Entity(name = "tb_comment")
public class CommentEntity extends BaseEntity {
    @Id private Long commentId;
    private String comment;
    private Long userId;
    private Long voteId;
}
