package com.stream;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class ParallelStream {
    public static void main(String[] args) {

        // A type of stream that allows parallel processing of elements
        // Allowing multiple threads to process parts of the stream simultaneously
        // This can significantly improve performance for large data sets

        long startTime = System.currentTimeMillis();
        List<Integer> list = Stream.iterate(1, integer -> integer + 1).limit(20000).toList();
        List<Long> factorialList = list.stream().map(ParallelStream::factorial).toList();
        long endTime = System.currentTimeMillis();

        System.out.println("Time taken with sequential stream :: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        factorialList = list.parallelStream().map(ParallelStream::factorial).toList();
        endTime = System.currentTimeMillis();

        System.out.println("Time taken with parallel stream :: " + (endTime - startTime));


        // Parallel stream doesn't work in case if the tasks we are performing are dependent on each other

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7);

        AtomicInteger sum = new AtomicInteger();

        //List<Integer> cumulativeSum = numbers.parallelStream().map(sum::addAndGet).toList(); // this wouldn't work as parallel stream is used here
        List<Integer> cumulativeSum = numbers.stream().map(sum::addAndGet).toList(); // this wouldn't work as parallel stream is used here
        System.out.println(cumulativeSum);

    }

    private static long factorial(int num) {
        long result = 1;
        for (int j = 2; j < num; j++) {

            result *= j;
        }
        return result;
    }
}
