package com.jdbcschoolproject.daos;


import com.jdbcschoolproject.models.Student;

import java.util.List;

public interface StudentDao {

     void insertStudent(Student student);
     void updateStudent(Student updatedStudent, int id);
     void deleteStudent(int id);
     Student getStudentById(int id);
     List<Student> getAllStudents();



}
