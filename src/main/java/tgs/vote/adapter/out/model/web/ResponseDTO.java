package tgs.vote.adapter.out.model.web;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public abstract class ResponseDTO {
    private final LocalDateTime responseDateTime = LocalDateTime.now();
}
