package com.jdbcschoolproject.daos;

import com.jdbcschoolproject.models.Teacher;

import java.util.List;

public interface TeacherDao {

    void insertTeacher(Teacher teacher);
    void updateTeacher(Teacher updatedTeacher, int id);
    void removeTeacher(int id);
    Teacher getTeacherById(int id);
    List<Teacher> getAllTeachers();
}
