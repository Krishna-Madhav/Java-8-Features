package com.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {

        // process collections of data in a functional and declarative manner
        // Simplifies data processing
        // Enable easy parallelism
        // improves readability and maintainability

        // What is Stream?
        // Stream is a collection (sequence) of items upon which supports functional and declarative programming

        // How to use Streams?
        // Source, intermediate operation(s) and  terminal operation

        List<String> list = Arrays.asList("Krishna", "Madhav", "Germany");
        System.out.println(list
                .stream()
                .filter(s -> s.startsWith("K"))
                .collect(Collectors.joining())
        );

        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(integerList
                .stream()
                .filter(integer -> integer % 2 == 0)
                .count()
        );

        //// Creating streams
        // 1. From collections
        List<Integer> integerListExample = Arrays.asList(1, 2, 3, 4, 5, 6);
        Stream<Integer> stream = integerListExample.stream();

        // 2. From Arrays
        String[] strArr = {"ABC", "DEF", "PQR", "XYZ"};
        Stream<String> stream1 = Arrays.stream(strArr);

        // 3. Using Stream.of()
        Stream<String> stream2 = Stream.of("A", "B", "C", "D");

        // 4. Infinite Streams
        Stream.generate(() -> 1).limit(100);
    }
}
