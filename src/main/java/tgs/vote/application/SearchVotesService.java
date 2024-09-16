package tgs.vote.application;

import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tgs.vote.application.in.GetUserUseCase;
import tgs.vote.application.in.GetVotesUseCase;
import tgs.vote.application.in.SearchVotesUseCase;
import tgs.vote.application.model.vote.GetVotesResult;
import tgs.vote.application.model.vote.SearchVotesCommand;
import tgs.vote.domain.user.User;

@RequiredArgsConstructor
@Service
public class SearchVotesService implements SearchVotesUseCase {
    private final GetVotesUseCase getVotesUseCase;
    private final GetUserUseCase getUserUseCase;

    @Transactional(readOnly = true)
    @Override
    public List<GetVotesResult> searchVotesBy(SearchVotesCommand command) {
        List<Long> voteCreatorUserIds = Collections.emptyList();
        if (StringUtils.hasLength(command.voteCreatorName())) {
            voteCreatorUserIds =
                    getUserUseCase.findByUserName(command.voteCreatorName()).stream()
                            .map(User::getUserId)
                            .toList();
        }

        return getVotesUseCase.getVotesBy(command.toGetVotesCommand(voteCreatorUserIds));
    }
}
