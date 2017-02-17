package com.example.java8;

import java.util.Arrays;
import java.util.Collection;

public class ReduceExample {
    public static void main(String[] args) {
        Collection<Integer> collection = Arrays.asList(1, 3, 4, 2);

        //Получить сумму чисел или вернуть 0
        System.out.println(
                collection
                        .stream()
                        .reduce((a, b) -> a + b)
                        .orElse(0)
        );

        //Вернуть максимум или -1
        System.out.println(
                collection
                        .stream()
                        .reduce(Integer::max)
                        .orElse(-1)
        );

        //Вернуть сумму нечетных чисел или 0
        System.out.println(
                collection
                        .stream()
                        .filter(i -> i % 2 != 0)
                        .reduce(Integer::sum)
                        .orElse(0)
        );
    }
}
