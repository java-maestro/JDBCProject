package com.jdbcschoolproject.controllers;

import com.jdbcschoolproject.services.StudentService;
import com.jdbcschoolproject.services.TeacherService;

import java.util.Scanner;

public class MainController {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StudentService studentServiceObject = new StudentService();
        TeacherService teacherServiceObject = new TeacherService();
        boolean exit = false;
        while (!exit) {
            System.out.println("Welcome to Our School....!");
            System.out.println(""" 
                    ----------------------------------------------------------------------------------------------------------------------------------
                    | 1. create student 🧑‍🎓   |  2. view student 🔍    | 3. update student ✍️ | 4. delete student ␥  | 5. get all students 🧑‍🎓🧑‍🎓🧑‍🎓🧑‍🎓          |
                    | 6. create Teacher 👨‍🏫   |  7. update Teacher ✍️  | 8. view Teacher 🔍   | 9. delete Teacher ❌ | 10. get all Teachers👨‍🏫👨‍🏫👩‍🏫👩‍🏫          |
                    | 11. Assign Teacher To Student   |  12. Assign Student to Teacher  |  13.  Unassign Teacher to Student | 14. Unassign Student to Teacher |
                    | 15. exit
                    -----------------------------------------------------------------------------------------------------------------------------------
                    """);
            System.out.println("Enter your choice: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    studentServiceObject.createStudent();
                    break;
                case 2:
                    studentServiceObject.viewStudent();
                    break;
                case 3:
                    studentServiceObject.updateStudent();
                    break;
                case 4:
                    studentServiceObject.deleteStudent();
                    break;
                case 5:
                    studentServiceObject.getAllStudents();
                    break;
                case 6:
                    teacherServiceObject.createTeacher();
                    break;
                case 7:
                    teacherServiceObject.updateTeacher();
                    break;
                case 8:
                    teacherServiceObject.getTeacher();
                    break;
                case 9:
                    teacherServiceObject.deleteTeacher();
                case 10:
                    teacherServiceObject.getAllTeachers();
                    break;
                case 11:
                    studentServiceObject.assignTeacherToStudent();
                    break;
                case 12:
                    exit = true;
                    break;
                case 13:
                    studentServiceObject.unAssignTeacherToStudent();
                    break;
                case 14:
                    exit = true;
                    break;
                case 15:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }


        }
    }
}
