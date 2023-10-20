package com.student.manage;

import java.sql.*;

public class StudentDao {

    public static boolean insertIntoDB(Student st){

        boolean flag = false;

        try {

            Connection con = CP.createConnection();

            String q = "insert into student(sname, phone, city) values(?, ?, ?)";

            // prepared statement
            PreparedStatement pstmnt = con.prepareStatement(q);
            // set values of parameter
            pstmnt.setString(1, st.getStudentName());
            pstmnt.setString(3, st.getStudentCity());
            pstmnt.setString(2, st.getStudentPhone());

            // execute
            pstmnt.executeUpdate();

            flag = true;

            con.close();

        } catch (Exception e){
            e.printStackTrace();
        }

        return flag;

    }

    public static boolean deleteStudent(int studentId) {

        boolean flag = false;

        try {

            Connection con = CP.createConnection();

            String q = "delete from student where sid=?";

            // prepared statement
            PreparedStatement pstmnt = con.prepareStatement(q);
            // set values of parameter
            pstmnt.setInt(1, studentId);

            // execute
            pstmnt.executeUpdate();

            flag = true;

            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return flag;
    }

    public static void showAllStudents() {

        try {

            Connection con = CP.createConnection();

            String q = "select * from student";

            Statement stmt = con.createStatement();

            ResultSet set = stmt.executeQuery(q);

            while (set.next()){
                int id = set.getInt(1);
                String name = set.getString(2);
                String phone = set.getString(3);
                String city = set.getString(4);

                System.out.println("==================");
                System.out.println("ID: "+id);
                System.out.println("Name: "+name);
                System.out.println("Phone: "+phone);
                System.out.println("City: "+city);
                System.out.println("==================");
            }

            con.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
