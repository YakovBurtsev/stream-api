package com.example.java8;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toSet;

public class SetSplitter {

    private static final int SIZE = 4;

    public static void main(String[] args) {
        Set<Integer> original = IntStream.rangeClosed(1, 11).boxed().collect(toSet());

        int subsetsCount = (int) Math.ceil(1.0 * original.size() / SIZE);

        System.out.println("subsetsCount=" + subsetsCount);
        for (int i = 0; i < subsetsCount; i++) {
            Set<Integer> set = original.stream().skip(i * SIZE).limit(SIZE).collect(Collectors.toSet());
            System.out.println(set);
        }
    }
}
