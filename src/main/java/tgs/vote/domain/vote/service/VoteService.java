package tgs.vote.domain.vote.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tgs.vote.domain.vote.entity.VoteEntity;
import tgs.vote.domain.vote.model.VoteGetListResponse;
import tgs.vote.domain.vote.repository.VoteRepository;

@RequiredArgsConstructor
@Service
public class VoteService {
    private final VoteRepository voteRepository;

    public List<VoteGetListResponse> getVoteList() {
        List<VoteEntity> voteEntityList = voteRepository.findByVoteCreator(1L);
        return null;
    }
}
