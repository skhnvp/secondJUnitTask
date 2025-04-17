package ru.stepup;

/*
Предположим, что мы изменили класс Студента таким образом,
что проверка корректности добавляемой оценки выполняется им не самостоятельно,
а с помощью сервиса checkGrade, который получает параметр grade и возвращает true или false.
Реализуйте заглушку сервиса и реализуйте тест на проверку того,
что правильные оценки попадают в список оценок, а неправильные нет.
*/

import ru.stepup.student.checkers.GradeChecker;
import ru.stepup.student.Student;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Student student = new Student("Ivan", new GradeChecker());
    }
}