package tgs.vote.domain.vote.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum QuestionType {
    SINGLE_SELECT("SINGLE_SELECT"),
    MULTI_SELECT("MULTI_SELECT"),
    FREE_RESPONSE("FREE_RESPONSE"),
    SCALE("SCALE");

    private final String code;
}
