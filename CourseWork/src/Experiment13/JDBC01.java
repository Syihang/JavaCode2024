package Experiment13;

import java.sql.*;

public class JDBC01 {

    public static void main(String[] args) throws SQLException {
        // 1.�������� (��ʡ��)

        // 2. ��ȡConnect����
        String url = "jdbc:mysql://127.0.0.1:3306/student?serverTimezone=UTC";
        String username = "root";
        String password = "123456";
        Connection con = DriverManager.getConnection(url, username, password);


        // 3.����sta����
        Statement stm = con.createStatement();



        // �������ݣ�
        String Insert_sql = """
                INSERT INTO stuinfo (stu_id, stu_name, birthday, sex, province, city)
                VALUES
                ('2205006224', '��һ��', '2003-05-02', '��', '�ӱ�', '����'),
                ('2205006001', '������', '2004-02-15', '��', '����', 'ʯ��ɽ'),
                ('2205006225', '�����', '1003-03-20', '��', '�㽭', '����');
                """;

        int rowsql = stm.executeUpdate(Insert_sql);

        System.out.println("�ɹ�������" + rowsql + "������");

        // ɾ�����ݣ�

        String sqlDelete = "DELETE FROM stuinfo WHERE stu_id = '2205006001'";
        int rowsDeleted = stm.executeUpdate(sqlDelete);
        System.out.println("��ɾ����" + rowsDeleted + "������");

        // �޸�����:
        String sqlUpdate = "UPDATE stuinfo SET provience = '����' WHERE stu_id = '2205006225'";
        int rowsUpdated = stm.executeUpdate(sqlUpdate);

        System.out.println("���޸���" + rowsUpdated + "������");
        // 4.ִ��sql
        String sql = "SELECT * FROM stuinfo";
        ResultSet rs = stm.executeQuery(sql);

        // 5. �鿴�����
        while(rs.next()){
            String id = rs.getString("stu_id");
            String name = rs.getString("stu_name");
            String birthday = rs.getString("birthday");
            String provience = rs.getString("provience");
            System.out.println("stu_id:" + id + "  stu_name:" + name + "  birthday:" + birthday +  "  provience" + provience);
        }

        // 6.�ر�
        rs.close();
        stm.close();
        con.close();
    }

}
