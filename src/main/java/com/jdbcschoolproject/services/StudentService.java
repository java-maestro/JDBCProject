package com.jdbcschoolproject.services;

import com.jdbcschoolproject.daos.StudentDao;
import com.jdbcschoolproject.daos.StudentDaoImpl;
import com.jdbcschoolproject.daos.TeacherDaoImpl;
import com.jdbcschoolproject.models.Student;
import com.jdbcschoolproject.models.Teacher;

import java.util.List;
import java.util.Scanner;

public class StudentService {

   private Scanner scanner;
   private StudentDaoImpl sDao;
   private TeacherDaoImpl teacherDaoImpl;

    public StudentService() {
        scanner = new Scanner(System.in);
        sDao = new StudentDaoImpl();
        teacherDaoImpl = new TeacherDaoImpl();
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
           List<Teacher> teachers = sDao.getAllAssignedTeachersToStudent(student.getId());
           for(Teacher teacher : teachers){
               System.out.println("            "+teacher);
           }
       }

    }


    public void assignTeacherToStudent(){
        // selecting student
        System.out.println("Enter student id that you want to assign teacher : ");
        int studentId = scanner.nextInt();
        // getting the student details
        Student student = sDao.getStudentById(studentId);
        List<Teacher> alreadyAssignedTeachers = sDao.getAllAssignedTeachersToStudent(studentId);
        //getting all teachers
        List<Teacher> teachers = teacherDaoImpl.getAllTeachers();
        System.out.println("Please enter teacher id that you want to select from below list : ");
        // checking if teacher is already assigned if not show this to student.
        for(Teacher teacher : teachers){
           if(!alreadyAssignedTeachers.contains(teacher)){
               System.out.println(teacher.getId() + " " + teacher.getName());
           }
        }
        int teacherId = scanner.nextInt();
        // need to impl a method to assign a teacher to a student
        sDao.assignTeacherToStudent(studentId, teacherId);

    }

    public void unAssignTeacherToStudent(){
        System.out.println("Enter student id that you want to unassign teacher : ");
        int studentId = scanner.nextInt();
        Student student = sDao.getStudentById(studentId);
        List<Teacher> alreadyAssignedTeachers = sDao.getAllAssignedTeachersToStudent(studentId);
        System.out.println("Please enter teacher id that you want to unassign from below list : ");
        for(Teacher teacher : alreadyAssignedTeachers){
            System.out.println(teacher.getId() + " " + teacher.getName());
        }
        int teacherId = scanner.nextInt();
        sDao.unAssignTeacherToStudent(studentId, teacherId);
    }
}
