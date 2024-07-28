package tgs.vote.application.in;

import java.util.List;
import tgs.vote.domain.vote.Question;
import tgs.vote.domain.vote.Vote;

public record CreateVoteInCommand(Vote vote, List<Question> questionList) {}
