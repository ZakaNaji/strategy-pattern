package org.znaji;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Discount newYearDiscount = price -> price * 0.9;
        Discount christmasDiscount = price -> price * 0.8;
        Discount aidilfitriDiscount = price -> price * 0.7;

        List<Discount> discounts = List.of(newYearDiscount, christmasDiscount, aidilfitriDiscount);

        Discount totalDiscount = discounts.stream()
                .reduce(p -> p, Discount::combine);

        System.out.println(totalDiscount.apply(100.0));

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