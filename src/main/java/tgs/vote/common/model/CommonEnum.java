package tgs.vote.common.model;

import lombok.Getter;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CommonEnum {
    @Getter
    public enum YesOrNo {
        YES("Y"),
        NO("N");

        YesOrNo(String code) {
            this.code = code;
        }

        private final String code;
    }
}
