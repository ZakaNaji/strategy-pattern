package org.znaji;

import java.util.function.UnaryOperator;

public interface Discount extends UnaryOperator<Double> {
    default Discount combine(Discount after) {
        return price -> after.apply(this.apply(price));
    }


}
