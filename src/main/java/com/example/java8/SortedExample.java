package com.example.java8;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class SortedExample {
    public static void main(String[] args) {
        testSorted();
    }

    private static void testSorted() {
        System.out.println();
        System.out.println("Test sorted start");

        // ************ Работа со строками
        Collection<String> collection = Arrays.asList("a1", "a4", "a3", "a2", "a1", "a4");

        // отсортировать значения по алфавиту
        List<String> sorted = collection.stream().sorted().collect(toList());
        System.out.println("sorted = " + sorted); // напечатает sorted = [a1, a1, a2, a3, a4, a4]

        // отсортировать значения по алфавиту и убрать дубликаты
        List<String> sortedDistinct = collection.stream().sorted().distinct().collect(toList());
        System.out.println("sortedDistinct = " + sortedDistinct); // напечатает sortedDistinct = [a1, a2, a3, a4]

        // отсортировать значения по алфавиту в обратном порядке
        List<String> sortedReverse = collection.stream().sorted((o1, o2) -> -o1.compareTo(o2)).collect(toList());
        System.out.println("sortedReverse = " + sortedReverse); // напечатает sortedReverse = [a4, a4, a3, a2, a1, a1]

        // отсортировать значения по алфавиту в обратном порядке  и убрать дубликаты
        List<String> distinctReverse = collection.stream().sorted((o1, o2) -> -o1.compareTo(o2)).distinct().collect(toList());
        System.out.println("distinctReverse = " + distinctReverse); // напечатает sortedReverse = [a4, a3, a2, a1]

        // ************ Работа с объектами
        // Зададим коллекцию людей
        Collection<Person> peoples = Arrays.asList(
                new Person("Вася", 16, Sex.MAN),
                new Person("Петя", 23, Sex.MAN),
                new Person("Елена", 42, Sex.WOMAN),
                new Person("Иван Иванович", 69, Sex.MAN)
        );

        // Отсортировать по имени в обратном алфавитном порядке
        Collection<Person> byName = peoples.stream().sorted((o1, o2) -> -o1.getName().compareTo(o2.getName())).collect(toList());
        System.out.println("byName = " + byName); // byName = [{name='Петя', age=23, sex=MAN}, {name='Иван Иванович', age=69, sex=MAN}, {name='Елена', age=42, sex=WOMAN}, {name='Вася', age=16, sex=MAN}]

        // Отсортировать сначала по полу, а потом по возрасту
        Collection<Person> bySexAndAge = peoples.stream().sorted((o1, o2) -> o1.getSex() != o2.getSex() ? o1.getSex().
                compareTo(o2.getSex()) : o1.getAge().compareTo(o2.getAge())).collect(toList());
        System.out.println("bySexAndAge = " + bySexAndAge); // bySexAndAge = [{name='Вася', age=16, sex=MAN}, {name='Петя', age=23, sex=MAN}, {name='Иван Иванович', age=69, sex=MAN}, {name='Елена', age=42, sex=WOMAN}]
    }
}
