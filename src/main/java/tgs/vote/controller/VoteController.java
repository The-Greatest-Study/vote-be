package tgs.vote.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tgs.vote.api.SupabaseApi;
import tgs.vote.vote.entity.VoteEntity;
import tgs.vote.vote.service.VoteService;

@RequiredArgsConstructor
@RestController
public class VoteController {
    private final SupabaseApi supabaseApi;
    private final VoteService voteService;

    @GetMapping("/vote/list")
    List<VoteEntity> getVoteList() {
        List<VoteEntity> voteListFromSupabase = supabaseApi.getVoteList();
        List<VoteEntity> voteListFromRepository = voteService.getVoteList();

        return voteListFromRepository;
    }
}
