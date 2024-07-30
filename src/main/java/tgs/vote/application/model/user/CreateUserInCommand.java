package tgs.vote.application.model.user;

import tgs.vote.domain.vote.Question;
import tgs.vote.domain.vote.Vote;

import java.util.List;

public record CreateUserInCommand(String authorizationCode) {
}
