package com.jdbcschoolproject.exceptions;

public class StudentNotFoundException extends  RuntimeException{
    public StudentNotFoundException(int  studentId) {
        super("Student with id " + studentId + " not found");
    }
}
