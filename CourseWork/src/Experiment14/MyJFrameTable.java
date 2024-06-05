package Experiment14;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class MyJFrameTable extends JFrame {


    public MyJFrameTable(){
        initJFrame();
        initNorth();
        initCenter();
        initSouth();
        setVisible(true);
    }


    private void initJFrame(){
        this.setTitle("学生信息管理系统");
        this.setSize(800, 500);
        this.setLocationRelativeTo(null);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initNorth(){
        JLabel studentTitle = new JLabel("学生信息管理系统");
        JButton clear = new JButton("清空");
        JButton retrieveAll = new JButton("全部检索");

        clear.addActionListener(e -> tableModel.setRowCount(0));

        retrieveAll.addActionListener(e -> {
            try {
                getAllStudent();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        JPanel north = new JPanel();

        north.add(studentTitle, FlowLayout.LEFT);
        north.add(clear, FlowLayout.CENTER);
        north.add(retrieveAll, FlowLayout.RIGHT);

        this.add(north, BorderLayout.NORTH);
    }

    // 表格中的数据
    Object[][] data = {};
    DefaultTableModel tableModel;
    JTable jTable;
    private void initCenter(){

        // 表格标题行
        Object[] cloumnNames = {"学号", "姓名", "出生日期", "性别", "所在省", "家庭住址"};

        tableModel = new DefaultTableModel(data, cloumnNames);
        jTable = new JTable(tableModel);
        JScrollPane center = new JScrollPane(jTable);

        jTable.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        // 添加边框线
        center.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        // 设置页边距
        center.setBorder(new EmptyBorder(0, 50, 0, 50));

        this.add(center, BorderLayout.CENTER);
    }


    private void initSouth(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5,7,5,5));
        JLabel id = new JLabel("学号");
        JLabel name = new JLabel("姓名");
        JLabel birthday = new JLabel("出生日期");
        JLabel sex = new JLabel("性别");
        JLabel provience = new JLabel("所在省");
        JLabel home = new JLabel("家庭地址");
        // 第一行
        panel.add(id);
        panel.add(name);
        panel.add(birthday);
        panel.add(sex);
        panel.add(provience);
        panel.add(home);
        panel.add(new JLabel());

        // 第二行
        JTextField jTextField1 = new JTextField();
        JTextField jTextField2 = new JTextField();
        JTextField jTextField3 = new JTextField();
        JTextField jTextField4 = new JTextField();
        JTextField jTextField5 = new JTextField();
        JTextField jTextField6 = new JTextField();

        panel.add(jTextField1);
        panel.add(jTextField2);
        panel.add(jTextField3);
        panel.add(jTextField4);
        panel.add(jTextField5);
        panel.add(jTextField6);

        JButton addStudent = new JButton("添加学生");
        addStudent.addActionListener(ex -> {
            try {
                addStudents(jTextField1.getText(), jTextField2.getText(), jTextField3.getText(),
                        jTextField4.getText(), jTextField5.getText(), jTextField6.getText() );
            }  catch (SQLException e) {
                if (e instanceof SQLSyntaxErrorException) {
                    // 处理 SQL 语法错误
                    System.out.println("SQL 语法错误，请检查 SQL 查询语句");
                } else if (e instanceof SQLIntegrityConstraintViolationException) {
                    // 处理主键重复或唯一约束冲突错误
                    System.out.println("主键重复或唯一约束冲突，请检查插入的数据是否已存在");
                } else {
                    // 其他 SQL 异常
                    System.out.println("SQL 异常：" + e.getMessage());
                }
            } catch (ParseException e) {
                // 处理日期解析异常
                System.out.println("日期解析异常：" + e.getMessage());
            }
        });
        panel.add(addStudent);

        // 第三行
        panel.add(new JTextField());
        panel.add(new JTextField());
        panel.add(new JTextField());
        panel.add(new JTextField());
        panel.add(new JTextField());
        panel.add(new JTextField());
        JButton editStudent = new JButton("修改学生");
        panel.add(editStudent);
        editStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    modifyStudents(jTextField1.getText(), jTextField2.getText(), jTextField3.getText(),
                            jTextField4.getText(), jTextField5.getText(), jTextField6.getText());
                } catch (SQLException | ParseException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // 第四行
        panel.add(new JTextField());
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());
        JButton deleteStudent = new JButton("删除学生");
        deleteStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    deleteStudents();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        panel.add(deleteStudent);

        // 第五行
        panel.add(new JTextField());
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());
        JButton findStudent = new JButton("查询学生");
        panel.add(findStudent);

        findStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    findStudents(jTextField1.getText(), jTextField2.getText(), jTextField3.getText(),
                            jTextField4.getText(), jTextField5.getText(), jTextField6.getText());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // 添加边框线
//        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        // 设置页面距
        panel.setBorder(new EmptyBorder(0, 50, 0, 50));

        this.add(panel, BorderLayout.SOUTH);
    }

    private void getAllStudent() throws SQLException {
        Connection con = DataControl.openData();
        Statement sta = con.createStatement();

        String sql = "SELECT * FROM stuinfo";
        ResultSet rs = sta.executeQuery(sql);

        // 清空表格数据
        tableModel.setRowCount(0);
        while (rs.next()) {
            // 从结果集中获取学生信息
            String id = rs.getString("stu_id");
            String name = rs.getString("stu_name");
            String birthday = rs.getString("birthday");
            String sex = rs.getString("sex");
            String province = rs.getString("province");
            String homeAddress = rs.getString("city");

            // 将学生信息添加到表格的数据模型中
            Object[] rowData = {id, name, birthday, sex, province, homeAddress};
            tableModel.addRow(rowData);
        }

//        initCenter();
    }

    private void addStudents(String id, String name, String bir, String sex,
                             String pro, String city) throws SQLException, ParseException {

        if (id.trim().equals("")){
            System.out.println("添加失败, 所添加学生的学号不能为空");
            return;
        }

        Connection con = DataControl.openData();

        // 处理日期格式
        java.sql.Date sqlDate = null;
        if (!bir.equals("")){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(bir);
            sqlDate = new java.sql.Date(date.getTime());
        }

        String sql = "INSERT INTO stuinfo (stu_id, stu_name, birthday, sex, province, city) VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, id.trim());
        preparedStatement.setString(2, name);
        preparedStatement.setDate(3, sqlDate);
        preparedStatement.setString(4, sex);
        preparedStatement.setString(5, pro);
        preparedStatement.setString(6, city);

        int rows = preparedStatement.executeUpdate();

        System.out.println("成功插入了" + rows + "条数据");

        preparedStatement.close();
        con.close();
    }

    private void deleteStudents() throws SQLException {
        int[] selectRows = jTable.getSelectedRows();
        if (selectRows.length == 0) {
            System.out.println("请先选择要删除的行");
            return;
        }
        Connection con = DataControl.openData();
        Statement stm = con.createStatement();
        // 依据列名获取索引(获取学号所在列的索引)
        int columnIndex = jTable.getColumnModel().getColumnIndex("学号");
        int count = 0;
        for(int x:selectRows){
            String id = jTable.getValueAt(x, columnIndex).toString();  // 获取该行学生的id
            String sqlDelete = "DELETE FROM stuinfo WHERE stu_id = " + id;
            count += stm.executeUpdate(sqlDelete);
        }

        // 移除所选择行
        for (int i = selectRows.length - 1; i >= 0; i--){
            tableModel.removeRow(selectRows[i]);
        }

        System.out.println("成功删除" + count + "组数据");
    }

    private void modifyStudents(String newId, String newName, String newBir, String newSex,
                                String newPro, String newCity) throws SQLException, ParseException {

        if (newId.trim().equals("")) {
            System.out.println("修改失败, 修改后的学号不能为空");
            return;
        }

        // 获取所选择行
        int selectStudent = jTable.getSelectedRow();
        if (selectStudent == -1) {
            System.out.println("修改失败，请先选择要修改的数据");
            return;
        }
        // 获取学号所在列
        int columnIndex = jTable.getColumnModel().getColumnIndex("学号");
        // 获取所选中学生的学号信息
        String id = jTable.getValueAt(selectStudent, columnIndex).toString();

        Connection con = DataControl.openData();
        String query = "UPDATE stuinfo SET stu_id = ?, stu_name = ?, birthday = ?, sex = ?, province = ?, city = ? WHERE stu_id = ?";
        PreparedStatement statement = con.prepareStatement(query);

        java.sql.Date sqlDate = null;
        if (!newBir.equals("")){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(newBir);
            sqlDate = new java.sql.Date(date.getTime());
        }

        statement.setString(1, newId);
        statement.setString(2, newName);
        statement.setDate(3, sqlDate); // Assuming newBir is a Date object
        statement.setString(4, newSex);
        statement.setString(5, newPro);
        statement.setString(6, newCity);
        statement.setString(7, id);
        statement.executeUpdate();

        System.out.println("成功修改学号为:" + id + "的学生信息");
    }

    private void findStudents(String newId, String newName, String newBir, String newSex,
                              String newPro, String newCity) throws SQLException {
        Connection con = DataControl.openData();
        String query = "SELECT * FROM stuinfo WHERE";

        StringBuilder queryBuilder = new StringBuilder("SELECT * FROM stuinfo WHERE 1 = 1");

        if (!newId.isEmpty()) {
            queryBuilder.append(" AND stu_id = '").append(newId).append("'");
        }

        if (!newName.isEmpty()) {
            queryBuilder.append(" AND stu_name = '").append(newName).append("'");
        }

        if (!newBir.isEmpty()) {
            queryBuilder.append(" AND birthday = '").append(newBir).append("'");
        }

        if (!newSex.isEmpty()) {
            queryBuilder.append(" AND sex = '").append(newSex).append("'");
        }

        if (!newPro.isEmpty()) {
            queryBuilder.append(" AND province = '").append(newPro).append("'");
        }

        if (!newCity.isEmpty()) {
            queryBuilder.append(" AND city = '").append(newCity).append("'");
        }

        Statement sta = con.createStatement();
        ResultSet rs = sta.executeQuery(queryBuilder.toString());

        tableModel.setRowCount(0);
        while (rs.next()) {
            // 从结果集中获取学生信息
            String id = rs.getString("stu_id");
            String name = rs.getString("stu_name");
            String birthday = rs.getString("birthday");
            String sex = rs.getString("sex");
            String province = rs.getString("province");
            String homeAddress = rs.getString("city");

            // 将学生信息添加到表格的数据模型中
            Object[] rowData = {id, name, birthday, sex, province, homeAddress};
            tableModel.addRow(rowData);
        }

        sta.close();
        con.close();
    }
}
