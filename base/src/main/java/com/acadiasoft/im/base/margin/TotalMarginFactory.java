package com.acadiasoft.im.base.margin;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;

public class TotalMarginFactory {

    public static TotalMargin build(ModelMargin child) {
        if (child.isMarginZero()) {
            return BlankImTree.getInstance();
        } else {
            return new TotalMargin(child.getMargin(), Collections.singletonList(child));
        }
    }

    public static TotalMargin build(ModelMargin one, ModelMargin two) {
        if (one.isMarginZero()) {
            return build(two);
        } else if (two.isMarginZero()) {
            return build(one);
        } else {
            BigDecimal sum = one.getMargin().add(two.getMargin());
            return new TotalMargin(sum, Arrays.asList(one, two));
        }
    }
}
