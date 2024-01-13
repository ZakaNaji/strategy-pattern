package org.znaji;

import java.util.function.UnaryOperator;

public interface DiscountStrategy extends UnaryOperator<Double> {
    default DiscountStrategy combine(DiscountStrategy after) {
        return price -> after.apply(this.apply(price));
    }


}
