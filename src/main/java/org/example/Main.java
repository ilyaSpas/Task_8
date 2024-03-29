package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Student1", Map.of("Math", 90, "Physics", 85)),
                new Student("Student2", Map.of("Math", 95, "Physics", 88)),
                new Student("Student3", Map.of("Math", 88, "Chemistry", 92)),
                new Student("Student4", Map.of("Physics", 78, "Chemistry", 85))
        );

        //Используйте Parallel Stream для обработки данных и создания Map, где ключ - предмет, а значение - средняя оценка по всем студентам.
        //Выведите результат: общую Map с средними оценками по всем предметам.
        Map<String, Double> averageScores = students.parallelStream()
                .flatMap(student -> student.getGrades().entrySet().parallelStream())
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.averagingDouble(Map.Entry::getValue)));

        System.out.println(averageScores);
    }
}