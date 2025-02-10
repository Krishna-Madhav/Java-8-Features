package com.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class Java8FunctionalInterface {

    public static void main(String[] args) {

        MathOperation mathOperation = (a, b) -> {
            System.out.println(a + b);
        };

        mathOperation.add(1, 5);

        // Predicate --> Functional Interface (Returns boolean value)
        Predicate<Integer> evenPredicate = integer -> integer % 2 == 0;
        System.out.println(evenPredicate.test(100));           // true
        System.out.println(evenPredicate.negate().test(100));  // false

        Predicate<Integer> oddPredicate = integer -> integer % 2 != 0;
        System.out.println(oddPredicate.negate().test(100));

        Predicate<String> wordStartsWithK = str -> str.toUpperCase().startsWith("K");
        System.out.println("Check wordStartsWithK: " + wordStartsWithK.test("Krishna"));
        Predicate<String> wordEndsWithA = str -> str.endsWith("a");
        System.out.println("Check wordEndsWithA: " + wordStartsWithK.test("Madhav"));

        Predicate<String> and = wordStartsWithK.and(wordEndsWithA);
        System.out.println("Testing and predicate: " + and.test("Krishna"));


        // Function interface -> It performs some task and returns an output
        Function<Integer, Integer> doubleIt = integer -> 2 * integer;
        Function<Integer, Integer> tripleIt = integer -> 3 * integer;

        System.out.println(doubleIt.apply(100));

        Function<Integer, Integer> mixedFunction = doubleIt.andThen(tripleIt);
        System.out.println(mixedFunction.apply(100));

        // Consumer interface -> It takes an item and consumes the item

        Consumer<Integer> integerConsumer = integer -> System.out.println(integer);
        integerConsumer.accept(101);

        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        Consumer<List<Integer>> integerArrayConsumer = integer -> {
            for (int x : list) {
                System.out.println(x);
            }
        };

        integerArrayConsumer.accept(list);


        // Supplier
        Supplier<String> giveValue = () -> "Hello World!";
        System.out.println(giveValue.get());


        // Mixed example
        Predicate<Integer> predicate = integer -> integer % 5 == 0;
        Function<Integer, Integer> function = integer -> integer * integer;
        Consumer<Integer> consumer = integer -> System.out.println(integer);
        Supplier<Integer> supplier = () -> 9990;

        if (predicate.test(supplier.get())) {
            consumer.accept(function.apply(supplier.get()));
        }

        // BiPredicate, BiConsumer and BiFunction

        BiPredicate<Integer, Integer> biPredicate = (integer1, integer2) -> (integer1 + integer2) % 2 == 0;
        System.out.println(biPredicate.test(5, 656));

        BiConsumer<Integer, String> biConsumer = (integer, string) -> {
            System.out.println("BiConsumer example :: " + integer + " , " + string);

        };

        biConsumer.accept(19, "Test string");

        BiFunction<String, String, Integer> biFunction = (x, y) -> (x + y).length();
        System.out.println(biFunction.apply("a", "bcdef"));

        UnaryOperator<Integer> unaryOperator = integer -> integer * 2;
        BinaryOperator<Integer> binaryOperator = (integer, integer2) -> integer + integer2;

        // Method reference -> Use method without invoking ... Used in place of lambda expression
        List<String> names = Arrays.asList("A", "B", "D");
        names.forEach(name -> System.out.print(name + " "));
        names.forEach(System.out::print );
    }
}


interface MathOperation {

    void add(int a, int b);

}