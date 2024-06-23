package tgs.vote.vote.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity(name = "tb_vote")
public class VoteEntity {
    @Id private Long vote_id;
    private String vote_title;
    private String vote_description;
    private String vote_thumbnail;
    private String vote_creator;
    private String vote_open_status;
    private String vote_anonymous_available_yn;
    private String vote_in_process_result_open_status;
    private String vote_end_result_open_status;
    private String vote_again_available_yn;
    private String vote_create_datetime;
    private String vote_start_datetime;
    private String vote_end_datetime;
}
