package tgs.vote.application.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tgs.vote.domain.vote.model.VoteGetListResponse;
import tgs.vote.domain.vote.service.VoteService;

@RequiredArgsConstructor
@RestController
public class VoteController {
    private final VoteService voteService;

    @GetMapping("/vote/list")
    List<VoteGetListResponse> getVoteList() {

        return voteService.getVoteList();
    }
}
