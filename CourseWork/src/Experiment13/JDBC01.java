package Experiment13;

import java.sql.*;

public class JDBC01 {

    public static void main(String[] args) throws SQLException {
        // 1.加载驱动 (可省略)

        // 2. 获取Connect连接
        String url = "jdbc:mysql://127.0.0.1:3306/student?serverTimezone=UTC";
        String username = "root";
        String password = "123456";
        Connection con = DriverManager.getConnection(url, username, password);


        // 3.生成sta对象
        Statement stm = con.createStatement();



        // 插入数据：
        String Insert_sql = """
                INSERT INTO stuinfo (stu_id, stu_name, birthday, sex, province, city)
                VALUES
                ('2205006224', '苏一行', '2003-05-02', '男', '河北', '保定'),
                ('2205006001', '吴煜鹏', '2004-02-15', '男', '宁夏', '石嘴山'),
                ('2205006225', '顾秋炜', '1003-03-20', '男', '浙江', '绍兴');
                """;

        int rowsql = stm.executeUpdate(Insert_sql);

        System.out.println("成功插入了" + rowsql + "条数据");

        // 删除数据：

        String sqlDelete = "DELETE FROM stuinfo WHERE stu_id = '2205006001'";
        int rowsDeleted = stm.executeUpdate(sqlDelete);
        System.out.println("共删除了" + rowsDeleted + "组数据");

        // 修改数据:
        String sqlUpdate = "UPDATE stuinfo SET provience = '宁夏' WHERE stu_id = '2205006225'";
        int rowsUpdated = stm.executeUpdate(sqlUpdate);

        System.out.println("共修改了" + rowsUpdated + "条数据");
        // 4.执行sql
        String sql = "SELECT * FROM stuinfo";
        ResultSet rs = stm.executeQuery(sql);

        // 5. 查看结果集
        while(rs.next()){
            String id = rs.getString("stu_id");
            String name = rs.getString("stu_name");
            String birthday = rs.getString("birthday");
            String provience = rs.getString("provience");
            System.out.println("stu_id:" + id + "  stu_name:" + name + "  birthday:" + birthday +  "  provience" + provience);
        }

        // 6.关闭
        rs.close();
        stm.close();
        con.close();
    }

}
