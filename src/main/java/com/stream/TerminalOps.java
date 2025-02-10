package com.stream;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class TerminalOps {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 1, 10, 11);

        // 1. collect
        Set<Integer> integerSet = list.stream().skip(1).collect(Collectors.toSet());
        System.out.println(integerSet);

        List<Integer> integerList = list.stream().collect(Collectors.toList());
        System.out.println(integerList);

        // 2. forEach
        list.stream().forEach(integer -> System.out.print(integer + " "));

        // 3. reduce : Combines elements to produce a single result
        Optional<Integer> optionalInteger = list.stream().reduce((integer, integer2) -> integer + integer2);
        System.out.println();
        System.out.println(optionalInteger.get());

        // 4. count
        System.out.println(list.stream().count());

        // 5. anyMatch, allMatch, noneMatch
        System.out.println(list.stream().anyMatch(integer -> integer % 2 == 0));
        System.out.println("Check all integers are even: " + list.stream().allMatch(integer -> integer % 2 == 0));
        System.out.println(list.stream().noneMatch(integer -> integer < 0));

        // 6. findFirst, findAny
        System.out.println(list.stream().findFirst().get());
        System.out.println(list.stream().findAny().get());

        // Example 1 : Filtering and collecting names
        List<String> names = Arrays.asList("Anna", "Bob", "Steve", "Sachin");
        System.out.println(names.stream().filter(string -> string.length() > 3).collect(Collectors.toList()));

        // Example 2 : Squaring and Sorting numbers
        List<Integer> intArr = Arrays.asList(1, 2, 3, 5, 6, 7, 23, 100, 8);
        System.out.println(intArr.stream().map(integer -> integer * integer).sorted().collect(Collectors.toList()));

        // Example 3 : Summing values
        List<Integer> intArr2 = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(intArr2.stream().reduce(Integer::sum).get());

        // Example 4 : Counting occurrences of a given character in a string
        String sentence = "Hello World";
        System.out.println(sentence.chars().filter(i -> i == 'k').count());

        // Example
        names.stream().forEach(System.out::print);

        // stateful & stateless - eg. map, filter and stateful - sorted, distinct

        // stateful - eg. distinct, sorted
        // stateless - eg. eg. map, filter are stateless
    }
}