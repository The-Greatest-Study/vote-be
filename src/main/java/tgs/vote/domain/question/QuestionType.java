package tgs.vote.domain.question;

public enum QuestionType {
    SINGLE_CHOICE("단수선택"),
    MULTIPLE_CHOICE("복수선택"),
    SHORT_ANSWER("주관식"),
    RATING("선호도");

    private final String displayName;

    QuestionType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
