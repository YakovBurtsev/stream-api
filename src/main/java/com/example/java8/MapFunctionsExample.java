package com.example.java8;

import java.util.Arrays;
import java.util.Collection;

import static java.util.stream.Collectors.toList;

public class MapFunctionsExample {
    public static void main(String[] args) {
        Collection<String> collection1 = Arrays.asList("a1", "a2", "a3", "a1");
        Collection<String> collection2 = Arrays.asList("1,2,0", "4,5");

        //Добавить "_1" к каждому элементу первой коллекции
        System.out.println(
                collection1
                        .stream()
                        .map(s -> s + "_1")
                        .collect(toList())
        );

        //В первой коллекции убрать первый символ и вернуть массив чисел (int[])
        System.out.println(
                collection1
                        .stream()
                        .mapToInt(s -> Integer.parseInt(s.substring(1)))
//                        .toArray()
                        .boxed()
                        .collect(toList())
        );

        //Из второй коллекции получить все числа, перечисленные через запятую из всех элементов
        System.out.println(
                collection2
                        .stream()
                        .flatMap(s -> Arrays.stream(s.split(",")))
//                        .toArray(String[]::new)
                        .collect(toList())
        );

        //Из второй коллекции получить сумму всех чисел, перечисленных через запятую
        System.out.println(
                collection2
                        .stream()
                        .flatMap(s -> Arrays.stream(s.split(",")))
                        .mapToInt(Integer::parseInt)
                        .sum()
        );
    }
}
