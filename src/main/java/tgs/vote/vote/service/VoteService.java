package tgs.vote.vote.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tgs.vote.vote.entity.VoteEntity;
import tgs.vote.vote.repository.VoteRepository;

import java.time.LocalDate;
import java.util.List;


@Service
@RequiredArgsConstructor
public class VoteService {

    private final VoteRepository voteRepository;

    public List<VoteEntity> retrieveOngoingVoteList() {
        return voteRepository.findOngoingVotes(LocalDate.now());
    }
}
