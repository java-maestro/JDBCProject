package com.jdbcschoolproject.controllers;

import com.jdbcschoolproject.services.StudentService;

import java.util.Scanner;

public class MainController {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StudentService studentServiceObject = new StudentService();
        boolean exit = false;
        while (!exit) {
            System.out.println("Welcome to Our School....!");
            System.out.println("1. create student 🧑‍🎓");
            System.out.println("2. view student 🔍");
            System.out.println("3. update student ✍️");
            System.out.println("4. delete student ␥");
            System.out.println("5. get all students 🧑‍🎓🧑‍🎓🧑‍🎓🧑‍🎓");
            System.out.println("6. exit");
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
                    exit = true;
                    break;
            }


        }
    }
}
