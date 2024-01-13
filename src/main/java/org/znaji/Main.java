package org.znaji;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DiscountStrategy newYearDiscountStrategy = price -> price * 0.9;
        DiscountStrategy christmasDiscountStrategy = price -> price * 0.8;
        DiscountStrategy aidilfitriDiscountStrategy = price -> price * 0.7;

        List<DiscountStrategy> discountStrategies = List.of(newYearDiscountStrategy, christmasDiscountStrategy, aidilfitriDiscountStrategy);

        DiscountStrategy totalDiscountStrategy = discountStrategies.stream()
                .reduce(p -> p, DiscountStrategy::combine);

        System.out.println(totalDiscountStrategy.apply(100.0));

        TextProcessorStrategy reverse = text -> new StringBuilder(text).reverse().toString();
        TextProcessorStrategy uppercase = String::toUpperCase;
        TextProcessorStrategy removeSpaces = text -> text.replaceAll(" ", "");
        TextProcessorStrategy reverseThenUppercase = reverse.combine(uppercase);

        System.out.println(reverse.process("Hello World"));
        System.out.println(uppercase.process("Hello World"));
        System.out.println(removeSpaces.process("Hello World"));
        System.out.println(reverseThenUppercase.process("Hello World"));
    }
}