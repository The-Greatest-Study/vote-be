package tgs.vote.application.in;

import tgs.vote.domain.vote.Vote;

public interface GetVoteUseCase {

    Vote getVoteDetail(Long id);

}
