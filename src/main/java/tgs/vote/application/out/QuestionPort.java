package tgs.vote.application.out;

import tgs.vote.domain.vote.VoteDetailQuestion;

import java.util.List;

public interface QuestionPort {
    List<VoteDetailQuestion> findQuestionListByVoteId(Long voteId);
}
