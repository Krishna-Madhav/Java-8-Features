package com.stream;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LazyEvaluationDemo {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // This whole code is not executed until terminal operation is performed
        Stream<String> stringStream = names.stream()
                .filter(name -> {
                    System.out.println("Filtering names :");
                    return name.length() > 4;
                });

        System.out.println("Before terminal operation : ");

        List<String> collect = stringStream.collect(Collectors.toList());

        System.out.println("After terminal operation");
        System.out.println(collect);

    }
}