package tgs.vote.adapter.out.model.web;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Builder(access = AccessLevel.PRIVATE)
@Getter
public class SuccessResponse<D> extends ResponseDTO {
    private D data;

    public static <D> SuccessResponse<D> of(D data) {
        return SuccessResponse.<D>builder().data(data).build();
    }
}
