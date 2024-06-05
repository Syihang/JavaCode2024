package test13;

import java.sql.*;

public class sy13 {
    public static void main(String[] args) throws SQLException {
        // 1.加载驱动 (可省略)

        // 2. 获取Connect连接
        String url = "jdbc:mysql://127.0.0.1:3306/zongheshixun?serverTimezone=UTC";
        String username = "root";
        String password = "123456";
        Connection con = DriverManager.getConnection(url, username, password);

        // 3.生成sta对象
        Statement stm = con.createStatement();

        // 4.执行sql
        String sql = "SELECT sname,phone FROM YJSB WHERE phone LIKE '139%'";
        ResultSet rs = stm.executeQuery(sql);

        // 5. 查看结果集
        while(rs.next()){
            String name = rs.getString("sname");
            String phone = rs.getString("phone");
            System.out.println(name + " " + phone);
        }

        // 6.关闭
        rs.close();
        stm.close();
        con.close();

    }
}
