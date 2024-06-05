package Experiment14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataControl {
    public static Connection openData() throws SQLException {
        Connection con = null;

        String url = "jdbc:mysql://127.0.0.1:3306/student?serverTimezone=UTC";
        String username = "root";
        String password = "123456";

        con = DriverManager.getConnection(url, username, password);

        return con;
    }

    public static boolean closeData(Connection con) throws SQLException {

        if (con != null){
            con.close();
            return con.isClosed();
        }

        return false;
    }
}
