package tgs.vote.adapter.model.vote;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import tgs.vote.application.model.vote.GetVotesSortItem;
import tgs.vote.common.model.InfrastructureEnum;
import tgs.vote.common.model.RestEnum;

@Getter
@RequiredArgsConstructor
public enum SearchVotesSortItem implements RestEnum, InfrastructureEnum {
    VOTE_START_DATE_TIME("voteStartDateTime", "start_datetime"),
    VOTE_END_DATE_TIME("voteEndDateTime", "end_datetime"),
    VOTE_TITLE("voteTitle", "title"),
    VOTE_CREATOR("voteCreator", "creator");

    private final String restCode;
    private final String infrastructureCode;

    public GetVotesSortItem toGetVotesSortItem() {
        return GetVotesSortItem.valueOf(this.name());
    }
}
