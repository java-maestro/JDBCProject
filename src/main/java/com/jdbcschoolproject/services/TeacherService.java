package com.jdbcschoolproject.services;

import com.jdbcschoolproject.daos.TeacherDaoImpl;
import com.jdbcschoolproject.models.Student;
import com.jdbcschoolproject.models.Teacher;

import java.util.List;
import java.util.Scanner;

public class TeacherService {

    Scanner scanner;
    TeacherDaoImpl teacherDaoImpl;

    public TeacherService() {
        scanner = new Scanner(System.in);
        teacherDaoImpl = new TeacherDaoImpl();
    }

    public void createTeacher() {
        System.out.println("Please enter your id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Please enter your salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Please enter your address: ");
        String address = scanner.nextLine();
        System.out.println("Please enter your email: ");
        String email = scanner.nextLine();
        System.out.println("Please enter your course name: ");
        String courseName = scanner.nextLine();

        Teacher teacher = new Teacher(id, name, salary, address, email, courseName);

        teacherDaoImpl.insertTeacher(teacher);
    }

    public void updateTeacher() {
        System.out.println("Enter Teacher id that you want to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Teacher teacher = teacherDaoImpl.getTeacherById(id);
        System.out.println(teacher);
        System.out.println("Which information would you like to update?");
        System.out.println("1. NAME, 2. SALARY, 3. EMAIL, 4. ADDRESS, 5 COURSE NAME");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                System.out.println("Enter updated teacher name :");
                String updatedName = scanner.nextLine();
                teacher.setName(updatedName);
                break;
            case 2:
                System.out.println("Enter updated teacher salary :");
                double updatedSalary = scanner.nextDouble();
                scanner.nextLine();
                teacher.setSalary(updatedSalary);
                break;
            case 3:
                System.out.println("Enter updated teacher email :");
                String updatedEmail = scanner.nextLine();
                teacher.setEmail(updatedEmail);
                break;
            case 4:
                System.out.println("Enter updated teacher address :");
                String updatedAddress = scanner.nextLine();
                teacher.setAddress(updatedAddress);
                break;
            case 5:
                System.out.println("Enter updated teacher course name :");
                String updatedCourseName = scanner.nextLine();
                teacher.setCourse(updatedCourseName);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }

        teacherDaoImpl.updateTeacher(teacher, id);
    }


    public void deleteTeacher() {
        System.out.println("Enter Teacher id that you want to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Teacher teacher = teacherDaoImpl.getTeacherById(id);
        System.out.println("Teacher deleted with id: " + id);
    }

    public void getTeacher() {
        System.out.println("Enter Teacher id that you want to view: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Teacher teacher = teacherDaoImpl.getTeacherById(scanner.nextInt());
        System.out.println(teacher);
    }
    public void getAllTeachers() {
        List<Teacher> teachers = teacherDaoImpl.getAllTeachers();
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
    }
}
