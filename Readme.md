# Steps to Run this project in your system

## step: 1 Clone the project 

## step: 2 Create a database 
        
`create a database jdbcschoolproject;`

## step 3: Create tables

`use jdbcschoolproject;`

`create table student(
id int primary key,
name varchar(30) not null,
age int(2),
email varchar(50) unique,
address varchar(200)
);`


`create table teacher(
id int primary key,
name varchar(30) not null,
salary double(5,2),
course varchar(20),
email varchar(50) unique,
address varchar(200)
);`


`create table student_teacher(
mapped_id int primary key auto_increment,
teacher_id int,
student_id int,
foreign key(teacher_id) references teacher(id),
foreign key(student_id) references student(id)
);`

`alter table student_teacher auto_increment = 100;`


## step 4: update the connection details in SQL connector class 

**DB_NAME = "jdbcschoolproject";**

**DB_USER = root** 

**DB_PASSWORD = give your own password**

**DB_URL = "jdbc:mysql//localhost:3306/" + DB_NAME**

## step 5: Update the Maven dependencies 

 right-click on the project => go to maven => click on a Reload project

## step 6: Run the Project 