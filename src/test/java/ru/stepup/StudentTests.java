package ru.stepup;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.stepup.student.interfaces.GradeCheck;
import ru.stepup.student.interfaces.GradeCheck.*;
import ru.stepup.student.Student;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StudentTests {
    private static GradeCheck gradeCheck;
    private static Student stud;

    @SneakyThrows
    @BeforeEach
    void gradeMock() {
        gradeCheck = mock(GradeCheck.class);
        when(gradeCheck.check(5)).thenReturn(true);
        when(gradeCheck.check(6)).thenReturn(false);

        stud = new Student("Ivan", gradeCheck);
    }

    @Test
    void trueGradeTest() {
        stud.addGrade(5);
        Assertions.assertEquals(5, stud.getGrades().get(0));
    }

    @Test
    void falseGradeTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> stud.addGrade(6));
    }
}
