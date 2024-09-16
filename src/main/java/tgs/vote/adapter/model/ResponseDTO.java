package tgs.vote.adapter.model;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Builder(access = AccessLevel.PRIVATE)
@Getter
public class ResponseDTO<D> {
    private final D data;
    private final ResponseError error;
    private final LocalDateTime responseDateTime = LocalDateTime.now();

    @Builder(access = AccessLevel.PRIVATE)
    @Getter
    public static class ResponseError {
        private final String code;
        private final String message;

        public static ResponseError of(String code, String message) {
            return ResponseError.builder().code(code).message(message).build();
        }
    }

    public static <D> ResponseDTO<D> ofSuccess(D data) {
        return ResponseDTO.<D>builder().data(data).build();
    }

    public static ResponseDTO<?> ofError(String code, String message) {
        return ResponseDTO.builder().error(ResponseError.of(code, message)).build();
    }
}
