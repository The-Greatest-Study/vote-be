package tgs.vote.vote.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class VoteEntity {

    @Id
    private Long id;
    private String title;
    private String description;
    private String startDate;
    private String endDate;
    private String creator;
    private String thumbnail;
    private String status;

}
