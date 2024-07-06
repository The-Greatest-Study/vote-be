package tgs.vote.adapter.out.model;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public class ErrorResponse {
    private LocalDateTime errorDateTime;
    private List<ErrorDetail> errorDetails;

    @Builder
    public static class ErrorDetail {
        private String code;
        private String message;
    }

    public static ErrorResponse create(List<ErrorDetail> errorDetails) {
        return ErrorResponse.builder()
                .errorDateTime(LocalDateTime.now())
                .errorDetails(errorDetails)
                .build();
    }
}
