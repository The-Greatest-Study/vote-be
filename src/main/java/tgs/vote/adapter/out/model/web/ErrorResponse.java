package tgs.vote.adapter.out.model.web;

import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Builder(access = AccessLevel.PRIVATE)
@Getter
public class ErrorResponse extends ResponseDTO {
    private List<ErrorDetail> errorDetails;

    @Builder(access = AccessLevel.PRIVATE)
    @Getter
    public static class ErrorDetail {
        private String code;
        private String message;

        public static ErrorDetail of(String code, String message) {
            return ErrorDetail.builder().code(code).message(message).build();
        }
    }

    public static ErrorResponse of(String code, String message) {
        ErrorDetail errorDetail = ErrorDetail.of(code, message);
        return ErrorResponse.of(List.of(errorDetail));
    }

    public static ErrorResponse of(List<ErrorDetail> errorDetails) {
        return ErrorResponse.builder().errorDetails(errorDetails).build();
    }
}
