package com.jdbcschoolproject.services;

import com.jdbcschoolproject.daos.StudentDao;
import com.jdbcschoolproject.daos.StudentDaoImpl;
import com.jdbcschoolproject.models.Student;

import java.util.List;
import java.util.Scanner;

public class StudentService {

   private Scanner scanner;
   private StudentDaoImpl sDao;

    public StudentService() {
        scanner = new Scanner(System.in);
        sDao = new StudentDaoImpl();
    }


    public void createStudent() {
        System.out.println("Enter student id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter student name: ");
        String name = scanner.nextLine();
        System.out.println("Enter student age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter student email: ");
        String email = scanner.nextLine();
        System.out.println("Enter student address: ");
        String address = scanner.nextLine();

        Student student = new Student(id, name, age, email, address);
        sDao.insertStudent(student);

    }

    public void viewStudent(){
        System.out.println("Enter student id that you are looking for: ");
        int id = scanner.nextInt();

        Student student = sDao.getStudentById(id);
        System.out.println("🧑‍🎓" + student);
    }



    public void updateStudent(){
        System.out.println("Enter student id that you want to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Student student = sDao.getStudentById(id);
        System.out.println(student);
        System.out.println("Which information would you like to update?");
        System.out.println("1. NAME, 2. AGE, 3. EMAIL, 4. ADDRESS");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if(choice == 1){
            System.out.println("Enter updated student name :");
            String updatedName = scanner.nextLine();
            student.setName(updatedName);
        }else if(choice == 2){
            System.out.println("Enter updated student age :");
            int updatedAge = scanner.nextInt();
            scanner.nextLine();
            student.setAge(updatedAge);
        }else if(choice == 3){
            System.out.println("Enter updated student email :");
            String updatedEmail = scanner.nextLine();
            student.setEmail(updatedEmail);
        }else if(choice == 4){
            System.out.println("Enter updated student address :");
            String updatedAddress = scanner.nextLine();
            student.setAddress(updatedAddress);

        }else{
            System.out.println("Invalid choice");
        }

        sDao.updateStudent(student, id);

    }
    public void deleteStudent(){
        System.out.println("Enter student id that you want to delete: ");
        int id = scanner.nextInt();
        sDao.deleteStudent(id);
    }
    public void getAllStudents(){
       List<Student> students = sDao.getAllStudents();

       for(Student student : students){
           System.out.println("🧑‍🎓" + student);
       }

    }
}
