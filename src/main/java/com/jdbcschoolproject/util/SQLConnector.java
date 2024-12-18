package com.jdbcschoolproject.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnector {
    static Connection  con= null;

    public static Connection establishConnection(){


        final String DB_NAME = "jdbcschoolproject";
        final String DB_URL = "jdbc:mysql://localhost:3306/"+ DB_NAME;
        final String DB_USER = "root";
        final String DB_PASSWORD = "123456789";

            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

//                System.out.println(con);
                System.out.println("Connected Successfully");
            }catch(ClassNotFoundException | SQLException exception){
                System.out.println("exception: " + exception.getMessage());
            }

            return con;
    }


    public static void closeConnection(){
       try {
           con.close();
       }catch (SQLException e){
           e.printStackTrace();
       }
    }


}
