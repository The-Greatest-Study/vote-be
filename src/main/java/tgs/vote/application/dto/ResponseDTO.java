package tgs.vote.application.dto;

import java.util.List;
import lombok.Getter;

public class ResponseDTO<D> {
    private D data;
    private ResponseStatus status;
    private List<Detail> detail;

    public static <D> ResponseDTO<D> ofSuccess(D data) {
        return new ResponseDTO<>(data, ResponseStatus.SUCCESS, null);
    }

    public static <D> ResponseDTO<D> ofFail(String message) {
        return new ResponseDTO<>(null, ResponseStatus.FAIL, null);
    }

    public static <D> ResponseDTO<D> ofError(String message) {
        return new ResponseDTO<>(null, ResponseStatus.ERROR, null);
    }

    public ResponseDTO(D data, ResponseStatus status, List<Detail> detail) {
        this.data = data;
        this.status = status;
        this.detail = detail;
    }

    public static class Detail {
        private String code;
        private String message;
    }

    @Getter
    public enum ResponseStatus {
        SUCCESS("success"),
        FAIL("fail"),
        ERROR("error");

        ResponseStatus(String statusCode) {
            this.statusCode = statusCode;
        }

        private final String statusCode;
    }
}
