package com.example.java8;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediateAndTerminalMethods {
    public static void main(String[] args) {
        Collection<String> collection = Arrays.asList("hello", "java", "world");
        // peek
        System.out.println(collection.stream().peek(e -> System.out.println("=" + e)).collect(Collectors.toList()));
        // map
        System.out.println(collection.stream().map(String::toUpperCase).collect(Collectors.toList()));

        Collection<String> list = Arrays.asList("1", "2", "3");
        System.out.println(list.stream().mapToInt(Integer::parseInt).boxed().collect(Collectors.toList()));


        //Terminal methods
        System.out.println(Stream.of(1, 3, 5).findAny().orElse(0));

    }

}
