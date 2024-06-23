package tgs.vote.vote.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tgs.vote.vote.entity.VoteEntity;
import tgs.vote.vote.repository.VoteRepository;

@RequiredArgsConstructor
@Service
public class VoteService {
    private final VoteRepository voteRepository;

    public List<VoteEntity> getVoteList() {
        List<VoteEntity> voteEntityList = voteRepository.findByVoteCreator("CoolCool");
        return voteEntityList;
    }
}
