package com.jdbcschoolproject.models;

import java.util.List;

public class Student {
    private int id;
    private String name;
    private int age;
    private  String email;
    private String address;
    private List<Teacher> teacherList;

    public Student(){

    }

    public Student(int id, String name, int age, String email, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }
    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    @Override
    public String toString() {
        return "[" +" id : "+ id + ", name : "+name+", age : "+age+", email : "+email+", address : "+address+"]";
    }
}
