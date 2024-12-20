package com.jdbcschoolproject.daos;


import com.jdbcschoolproject.models.Student;
import com.jdbcschoolproject.models.Teacher;

import java.util.List;

public interface StudentDao {

     void insertStudent(Student student);
     void updateStudent(Student updatedStudent, int id);
     void deleteStudent(int id);
     Student getStudentById(int id);
     List<Student> getAllStudents();
     void assignTeacherToStudent(int studentId, int teacherId);
     List<Teacher> getAllAssignedTeachersToStudent(int studentId);
     void unAssignTeacherToStudent(int studentId, int teacherId);
}
