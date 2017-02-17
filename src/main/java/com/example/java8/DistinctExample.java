package com.example.java8;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import static java.util.stream.Collectors.toList;

public class DistinctExample {
    public static void main(String[] args) {
        Collection<String> ordered = Arrays.asList("a1", "a2", "a2", "a3", "a1", "a2", "a2");
        Collection<String> nonOrdered = new HashSet<>(ordered);
        System.out.println(
                ordered
                        .stream()
                        .distinct()
                        .collect(toList())
        );
        System.out.println(
                nonOrdered
                        .stream()
                        .distinct()
                        .collect(toList())
        );
    }
}
