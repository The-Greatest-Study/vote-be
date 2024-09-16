package tgs.vote.application.in;

import java.util.List;
import tgs.vote.application.model.vote.GetVotesResult;
import tgs.vote.application.model.vote.SearchVotesCommand;

public interface SearchVotesUseCase {
    List<GetVotesResult> searchVotesBy(SearchVotesCommand command);
}
