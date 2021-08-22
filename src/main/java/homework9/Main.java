package homework9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
// 1 Написать функцию, принимающую список Student и возвращающую список уникальных курсов, на которые подписаны студенты
public class Main {
 public static void main(String[] args) {
// Создаю список студентов
     List<Student> students = new ArrayList<>();
// Добавляю в список значения
     students.add(new Student("Dmitriy", Arrays.asList(new Course("Math"), new Course("Biology"),
             new Course("Testing"))));
     students.add(new Student("Anton", Arrays.asList(new Course("Math"), new Course("Geography"),
             new Course("Testing8"), new Course("Testing2"))));
     students.add(new Student("Oksana", Arrays.asList(new Course("Physics"), new Course("Biology"),
             new Course("Testing"), new Course("Testing1"))));
// Создаю из списка студентов stream
     System.out.println(students.stream()
// Избавляюсь от лишней информации
  .map(s -> s.getCourses())
        .flatMap(f -> f.stream())
        .collect(Collectors.toSet()));
// 2 Написать функцию, принимающую на вход список Student и возвращающую список из трех самых любознательных
//(любознательность определяется количеством курсов).
// Создаю метод вывода уникальных значений списка
     System.out.println(students.stream()
             .sorted((s1, s2) -> s2.getCourses().size() - s1.getCourses().size())
// Ограничиваю вывод результата 2 значениями
             .limit(2)
             .collect(Collectors.toList()));
// 3 Написать функцию, принимающую на вход список Student и экземпляр Course, возвращающую список студентов, которые посещают
// этот курс.
Course course = new Course("Testing");
     System.out.println(students.stream()
     .filter(s -> s.getCourses().contains(course))
     .collect(Collectors.toList()));
 }
}