package com.jdbcschoolproject.daos;

import com.jdbcschoolproject.models.Teacher;
import com.jdbcschoolproject.util.SQLConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDaoImpl implements TeacherDao {

    @Override
    public void insertTeacher(Teacher teacher) {

        try(Connection connection = SQLConnector.establishConnection();){

            String sql = "INSERT INTO teacher (id,name,salary,course, email, address) VALUES (?, ?, ?, ?, ?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, teacher.getId());
            preparedStatement.setString(2, teacher.getName());
            preparedStatement.setDouble(3, teacher.getSalary());
            preparedStatement.setString(4, teacher.getCourse());
            preparedStatement.setString(5, teacher.getEmail());
            preparedStatement.setString(6, teacher.getAddress());

            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateTeacher(Teacher updatedTeacher, int id) {

        try(Connection connection = SQLConnector.establishConnection();){

            String sql = "update teacher set name = ? , salary = ? , course = ? , email = ? , address = ? where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, updatedTeacher.getName());
            preparedStatement.setDouble(2, updatedTeacher.getSalary());
            preparedStatement.setString(3, updatedTeacher.getCourse());
            preparedStatement.setString(4, updatedTeacher.getEmail());
            preparedStatement.setString(5, updatedTeacher.getAddress());
            preparedStatement.setInt(6, id);

            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }


    }

    @Override
    public void removeTeacher(int id) {
        try(Connection connection = SQLConnector.establishConnection();){

            String sql = "delete from teacher where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Teacher getTeacherById(int id) {
        try(Connection connection = SQLConnector.establishConnection();){

            String sql = "select * from teacher where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            if(rs.next()){
                Teacher teacher = new Teacher();
                teacher.setId(id);
                teacher.setName(rs.getString("name"));
                teacher.setSalary(rs.getDouble("salary"));
                teacher.setCourse(rs.getString("course"));
                teacher.setEmail(rs.getString("email"));
                teacher.setAddress(rs.getString("address"));
                return teacher;
            }else{
                System.out.println("Teacher not found");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        try(Connection connection = SQLConnector.establishConnection();){

            String sql = "select * from teacher";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();
            List<Teacher> teachers = new ArrayList<>();
            while (rs.next()){
                Teacher teacher = new Teacher();
                teacher.setId(rs.getInt("id"));
                teacher.setName(rs.getString("name"));
                teacher.setSalary(rs.getDouble("salary"));
                teacher.setCourse(rs.getString("course"));
                teacher.setEmail(rs.getString("email"));
                teacher.setAddress(rs.getString("address"));
                teachers.add(teacher);
            }
          return teachers;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
