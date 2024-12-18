package com.jdbcschoolproject.daos;

import com.jdbcschoolproject.exceptions.StudentNotFoundException;
import com.jdbcschoolproject.models.Student;
import com.jdbcschoolproject.util.SQLConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

//     1. use connection
//     2. create SQL statement
//     3. prepare SQL statement
//     4. execute statement

    @Override
    public void insertStudent(Student student) {

        try (Connection connection = SQLConnector.establishConnection();) {
//                                                                                   1 2 3 4 5
            String sql = "insert into student(id, name, age, email, address) values (?,?,?,?,?)";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, student.getId());
            ps.setString(2, student.getName());
            ps.setInt(3, student.getAge());
            ps.setString(4, student.getEmail());
            ps.setString(5, student.getAddress());

            ps.executeUpdate();

            System.out.println("Added student successfully with id " + student.getId());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStudent(Student updatedStudent, int id) {

        try (Connection connection = SQLConnector.establishConnection();) {
//                                                  1       2        3          4           5
            String sql = "update student set name = ?, age =?, email=?, address=? where id= ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, updatedStudent.getName());
            ps.setInt(2, updatedStudent.getAge());
            ps.setString(3, updatedStudent.getEmail());
            ps.setString(4, updatedStudent.getAddress());
            ps.setInt(5, id);

            ps.executeUpdate();

            System.out.println("Updated student successfully with id " + id);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudent(int id) {
//     1. use connection
        try (Connection connection = SQLConnector.establishConnection();) {
//     2. create SQL statement
            String sql = "delete from student where id= ?;";

//     3. prepare SQL statement
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

//     4. execute statement
            ps.executeUpdate();
            System.out.println("Deleted student successfully with id " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student getStudentById(int id) throws StudentNotFoundException{

        //     1. use connection
        try (Connection connection = SQLConnector.establishConnection();) {
//     2. create SQL statement
            String sql = "select * from student where id= ?"  ;

//     3. prepare SQL statement
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

//     4. execute statement
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setEmail(rs.getString("email"));
                student.setAddress(rs.getString("address"));
                return student;
            }else{
                throw new StudentNotFoundException(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Student> getAllStudents() {

        List<Student> listOfStudents = new ArrayList<>();
        //     1. use connection
        try (Connection connection = SQLConnector.establishConnection();) {
//     2. create SQL statement
            String sql = "select * from student"  ;

//     3. prepare SQL statement
            PreparedStatement ps = connection.prepareStatement(sql);

//     4. execute statement
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setEmail(rs.getString("email"));
                student.setAddress(rs.getString("address"));
                listOfStudents.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfStudents;
    }
}