package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CP {

    static Connection con;

    public static Connection createConnection() {

        try {

            // load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // create the connection
            String url = "jdbc:mysql://localhost:3306/student_management";
            String username = "root";
            String password = "mysql123";

            con = DriverManager.getConnection(url, username, password);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return con;
    }
}
