package com.example.java8;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class ExampleOfFilterFindFirstFindAnySkipLimitCount {
    public static void main(String[] args) {
        //Условие: дана коллекция строк Arrays.asList("a1", "a2", "a3", "a1"),
        // давайте посмотрим как её можно обрабатывать используя методы filter, findFirst, findAny, skip и count:

        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");

        //Вернуть количество вхождений объекта "a1"
        System.out.println(collection.stream().filter("a1"::equals).count());

        //Вернуть первый элемент коллекции или 0, если коллекция пуста
        System.out.println(collection.stream().findFirst().orElse("0"));

        //Вернуть последний элемент коллекции или "empty", если коллекция пуста
        System.out.println(collection.stream().skip(collection.size() - 1).findAny().orElse("empty"));

        //Найти элемент в коллекции равный "a3" или кинуть ошибку
        System.out.println(collection.stream().filter("a3"::equals).findFirst().get());

        //Вернуть третий элемент коллекции по порядку
        System.out.println(collection.stream().skip(2).findFirst().get());

        //Вернуть два элемента начиная со второго
        System.out.println(collection.stream().skip(1).limit(2).collect(Collectors.toList()));

        //Выбрать все элементы содержащие 1
        System.out.println(collection.stream().filter((s) -> s.contains("1")).collect(Collectors.toList()));


        //Условие: дана коллекция класс Person (с полями name — имя, age — возраст, sex — пол),
        // вида Arrays.asList( new Person("Вася", 16, Sex.MAN), new Person("Петя", 23, Sex.MAN),
        // new Person("Елена", 42, Sex.WOMAN), new Person("Иван Иванович", 69, Sex.MAN)).
        // Давайте посмотрим примеры как работать с таким классом: 
        Collection<Person> people = Arrays.asList(
                new Person("Вася", 16, Sex.MAN),
                new Person("Петя", 23, Sex.MAN),
                new Person("Елена", 42, Sex.WOMAN),
                new Person("Иван Иванович", 69, Sex.MAN)
        );

        //Выбрать мужчин-военнообязанных (от 18 до 27 лет)
        System.out.println(
                people
                        .stream()
                        .filter(p -> p.getAge() >= 18 && p.getAge() < 27 && p.getSex() == Sex.MAN)
                        .collect(Collectors.toList())
        );

        //Найти средний возраст среди мужчин
        System.out.println(
                people
                        .stream()
                        .filter(p -> p.getSex() == Sex.MAN)
                        .mapToInt(Person::getAge)
                        .average()
                        .getAsDouble()
        );

        //Найти кол-во потенциально работоспособных людей в выборке
        // (т.е. от 18 лет и учитывая что женщины выходят в 55 лет, а мужчина в 60)
        System.out.println(
                people
                        .stream()
                        .filter(p -> p.getAge() >= 18)
                        .filter(p -> (p.getSex() == Sex.MAN && p.getAge() < 60) || (p.getSex() == Sex.WOMAN && p.getAge() < 55))
                        .count()
        );
    }
}
