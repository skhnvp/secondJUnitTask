package ru.stepup.student.interfaces;

import org.apache.hc.core5.http.ParseException;

import java.io.IOException;

public interface GradeCheck {
    public boolean check(int grade) throws IOException, ParseException;
}
