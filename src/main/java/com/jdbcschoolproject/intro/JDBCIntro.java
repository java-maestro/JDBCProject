package com.jdbcschoolproject.intro;

public class JDBCIntro {

    public static void main(String[] args) {

        // JDBC - Java Database Connectivity.

        // my SQL Driver Lib -> mysql-connector-j


        //  DriverManager (class)  => this will be sued to create a connection to our database.
        //  Connection (Interface) => This represents a physical connection to a database.
        //  Statement (Interface)  => This represents an SQL statements to send to the database.
        //  PreparedStatement (Interface) => this represents an SQL statement that is ready to accept parameters.
        //  ResultSet (Interface) => this represents a response to query from the database.


        // DAO design Pattern
        // DAO => Data access object.
        // -> it provides a clean separation between the business logic and data access logic.

        // DAOs => Abstract CRUD => (create, Read, update, delete) operations on Specific Entity.
        //  DAO Interface
        //  DAO Implementation => This will implement the DAO Interface.

        // Entity / Models => POJO class => Plain old Java Object class => Java Template for SQL Table
        // Services => Build the business logic.
        // Controller => users will interact with this layer to perform certain operations or actions.
        // Util => for utility functions



        // Data flow

        // user  => controller => service => DAO Implemented class => database.
    }
}
