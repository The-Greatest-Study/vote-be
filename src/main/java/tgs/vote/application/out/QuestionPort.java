package tgs.vote.application.out;

import tgs.vote.domain.vote.Question;

public interface QuestionPort {
    Question save(Question question);
}
