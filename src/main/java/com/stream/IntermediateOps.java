package com.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediateOps {

    public static void main(String[] args) {

        // Intermediate operation transforms a stream into another stream
        // They don't execute until a terminal operation is executed

        List<String> list = Arrays.asList("ABCD", "QERTY", "ADCDE", "XYZA", "ABCD");

        // 1. filter

        Stream<String> stringStream1 = list.stream().filter(s -> s.startsWith("A"));
        System.out.println("Count of strings that starts with A: " + stringStream1.count());
        System.out.println();

        // 2. map
        Stream<String> stringStream2 = list.stream().map(s -> s.toUpperCase());

        // 3. sorted
        list.stream().sorted().collect(Collectors.joining());
        list.stream().sorted((s1, s2) -> s1.length() - s2.length());

        // 4. distinct
        long distinctCount = list.stream().filter(s -> s.startsWith("A")).distinct().count();
        System.out.println("distinctCount: " + distinctCount);

        // 5. limit
        Stream.iterate(1, integer -> integer + 1).limit(100);

        // 6. skip
        Stream.iterate(1, integer -> integer +1).skip(10).limit(100);

        // 7. flatMap
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("apple", "banana"),
                Arrays.asList("kiwi", "orange"),
                Arrays.asList("guava", "mango")
        );

        System.out.println(listOfLists.get(0).get(1));

        List<String> flattenedList = listOfLists.stream()
                .flatMap(x -> x.stream())
                .map(String::toUpperCase)
                .toList();

        System.out.println(flattenedList);

        List<String> sentences = Arrays.asList(
                "Hello World",
                "Java streams are powerful",
                "flatMap is useful"
        );

        List<String> list1 = sentences.stream()
                .flatMap(string -> Arrays.stream(string.split(" "))).toList();

        System.out.println(list1);
    }
}
