package com.stream;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsDemo {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Alice", "Peter", "Bob", "Steve", "Sachin", "Virat", "Dhoni");

        // 1. Collecting to a List

        List<String> list = names.stream().filter(name -> name.startsWith("A")).collect(Collectors.toList());
        System.out.println(list);

        // 2. Collecting to a Set

        List<Integer> integers = Arrays.asList(1, 1, 2, 2, 3, 3, 5, 6, 7, 8, 2, 1, 10);
        Set<Integer> integerSet = integers.stream().collect(Collectors.toSet());
        System.out.println(integerSet);

        // 3. Collecting to a specified collection

        LinkedList<Integer> collectToSpecifiedCollection = integers.stream().collect(Collectors.toCollection(() -> new LinkedList<>()));
        System.out.println(collectToSpecifiedCollection);

        // 4. Joining strings
        // Used for concatenating stream to a single String

        String joinedStrings = names.stream().map(string -> string.toUpperCase()).collect(Collectors.joining(" "));
        System.out.println(joinedStrings);

        // 5. Summarizing data
        // Min, Max, Sum, Average, Count
        IntSummaryStatistics stats = integers.stream().collect(Collectors.summarizingInt(integer -> integer));
        System.out.print(
                "\n getMax : " + stats.getMax() +
                        "\n getAverage : " + stats.getAverage() +
                        "\n getMin : " + stats.getMin() + "\n getSum : " + stats.getSum()
        );

        // 6. Average
        Double average = integers.stream().collect(Collectors.averagingInt(integer -> integer));
        System.out.println(" Average : " + average);

        // 7. Counting
        System.out.println(" Count : " + integers.stream().collect(Collectors.counting()));

        // 8. Grouping elements
        Map<Integer, List<String>> groupedBySize = names.stream().collect(Collectors.groupingBy(name -> name.length()));
        System.out.println(groupedBySize);

        Map<Integer, String> groupBySize2 = names.stream().collect(Collectors.groupingBy(String::length, Collectors.joining(" , ")));
        System.out.println(groupBySize2);

        Map<Integer, Long> groupBySize3 = names.stream().collect(Collectors.groupingBy(string -> string.length(), Collectors.counting()));
        System.out.println(groupBySize3);

        TreeMap<Integer, Long> groupBySize4 = names.stream().collect(Collectors.groupingBy(string -> string.length(), TreeMap::new, Collectors.counting()));
        System.out.println(groupBySize4);

        // 9. Partitioning elements
        Map<Boolean, List<String>> partitionedData = names.stream().collect(Collectors.partitioningBy(string -> string.length() > 5));
        System.out.println(partitionedData);

        // 10. Mapping and Collecting
        List<String> collect = names.stream().collect(Collectors.mapping(string -> string.toUpperCase(), Collectors.toList()));
        System.out.println(collect);


        // Example 1: Collecting names by length
        System.out.println(names.stream().collect(Collectors.groupingBy(name -> name.length())));

        // Example 2: Counting word occurrences
        String sentence = "Hello World Hello Krishna This is the best day of my life";

        Map<String, Long> countWordOccurence = Arrays.stream(sentence.split(" ")).collect(Collectors.groupingBy(string -> string, Collectors.counting()));
        System.out.println(countWordOccurence);

        // Example 3: Partitioning even and odd numbers
        Map<Boolean, List<Integer>> partitionEvenOdd = integers.stream().collect(Collectors.partitioningBy(integer -> integer % 2 == 0));
        System.out.println(partitionEvenOdd);

        // Example 4: Summing values in a fruitsMap
        Map<String, Integer> items = new HashMap<>();
        items.put("Apple", 10);
        items.put("Banana", 25);
        items.put("Orange", 50);

        Optional<Integer> sumOfValuesHashMap = items.values().stream().reduce((integer, integer2) -> integer + integer2);
        System.out.println(sumOfValuesHashMap.get());

        // Example 5: Creating a fruitsMap from stream elements
        List<String> fruits = Arrays.asList("Apple", "Mango", "Cherry", "Banana","Grapes");
        Map<String, Integer> fruitsMap = fruits.stream().collect(Collectors.toMap(k -> k.toUpperCase(), v -> v.length()));
        System.out.println(fruitsMap);

    }
}
