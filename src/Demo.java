import java.sql.*;

public class Demo {

    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/students";
        String username = "root";
        String password = "mysql123";

        String query = "select name from students";

        Connection con = DriverManager.getConnection(url, username, password);
        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery(query);
        rs.next();

        String name = rs.getString(1);

        System.out.println(name);

        con.close();

    }
}
