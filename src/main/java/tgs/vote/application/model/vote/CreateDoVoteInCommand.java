package tgs.vote.application.model.vote;

import java.util.List;

import tgs.vote.domain.answer.Answer;
import tgs.vote.domain.vote.Question;
import tgs.vote.domain.vote.Vote;

public record CreateDoVoteInCommand(Vote vote, List<Question> questionList, List<Answer> answerList) {}
