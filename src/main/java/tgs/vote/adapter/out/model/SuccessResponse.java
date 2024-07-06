package tgs.vote.adapter.out.model;

import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public class SuccessResponse<D> {
    private D data;

    public static <D> SuccessResponse<D> create(D data) {
        return SuccessResponse.<D>builder().data(data).build();
    }
}
