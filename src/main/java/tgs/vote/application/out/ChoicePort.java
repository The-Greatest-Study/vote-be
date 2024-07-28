package tgs.vote.application.out;

import tgs.vote.domain.vote.Choice;

public interface ChoicePort {
    Choice save(Choice choice);
}
