package tgs.vote.application.in;

import java.util.List;
import tgs.vote.application.model.vote.GetVotesCommand;
import tgs.vote.application.model.vote.GetVotesResult;

public interface GetVotesUseCase {
    List<GetVotesResult> getVotesBy(GetVotesCommand command);
}
