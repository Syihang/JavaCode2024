package test13;

import java.sql.*;

public class sy13 {
    public static void main(String[] args) throws SQLException {
        // 1.�������� (��ʡ��)

        // 2. ��ȡConnect����
        String url = "jdbc:mysql://127.0.0.1:3306/zongheshixun?serverTimezone=UTC";
        String username = "root";
        String password = "123456";
        Connection con = DriverManager.getConnection(url, username, password);

        // 3.����sta����
        Statement stm = con.createStatement();

        // 4.ִ��sql
        String sql = "SELECT sname,phone FROM YJSB WHERE phone LIKE '139%'";
        ResultSet rs = stm.executeQuery(sql);

        // 5. �鿴�����
        while(rs.next()){
            String name = rs.getString("sname");
            String phone = rs.getString("phone");
            System.out.println(name + " " + phone);
        }

        // 6.�ر�
        rs.close();
        stm.close();
        con.close();

    }
}
