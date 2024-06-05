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
        this.setTitle("ѧ����Ϣ����ϵͳ");
        this.setSize(800, 500);
        this.setLocationRelativeTo(null);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initNorth(){
        JLabel studentTitle = new JLabel("ѧ����Ϣ����ϵͳ");
        JButton clear = new JButton("���");
        JButton retrieveAll = new JButton("ȫ������");

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

    // ����е�����
    Object[][] data = {};
    DefaultTableModel tableModel;
    JTable jTable;
    private void initCenter(){

        // ��������
        Object[] cloumnNames = {"ѧ��", "����", "��������", "�Ա�", "����ʡ", "��ͥסַ"};

        tableModel = new DefaultTableModel(data, cloumnNames);
        jTable = new JTable(tableModel);
        JScrollPane center = new JScrollPane(jTable);

        jTable.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        // ��ӱ߿���
        center.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        // ����ҳ�߾�
        center.setBorder(new EmptyBorder(0, 50, 0, 50));

        this.add(center, BorderLayout.CENTER);
    }


    private void initSouth(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5,7,5,5));
        JLabel id = new JLabel("ѧ��");
        JLabel name = new JLabel("����");
        JLabel birthday = new JLabel("��������");
        JLabel sex = new JLabel("�Ա�");
        JLabel provience = new JLabel("����ʡ");
        JLabel home = new JLabel("��ͥ��ַ");
        // ��һ��
        panel.add(id);
        panel.add(name);
        panel.add(birthday);
        panel.add(sex);
        panel.add(provience);
        panel.add(home);
        panel.add(new JLabel());

        // �ڶ���
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

        JButton addStudent = new JButton("���ѧ��");
        addStudent.addActionListener(ex -> {
            try {
                addStudents(jTextField1.getText(), jTextField2.getText(), jTextField3.getText(),
                        jTextField4.getText(), jTextField5.getText(), jTextField6.getText() );
            }  catch (SQLException e) {
                if (e instanceof SQLSyntaxErrorException) {
                    // ���� SQL �﷨����
                    System.out.println("SQL �﷨�������� SQL ��ѯ���");
                } else if (e instanceof SQLIntegrityConstraintViolationException) {
                    // ���������ظ���ΨһԼ����ͻ����
                    System.out.println("�����ظ���ΨһԼ����ͻ���������������Ƿ��Ѵ���");
                } else {
                    // ���� SQL �쳣
                    System.out.println("SQL �쳣��" + e.getMessage());
                }
            } catch (ParseException e) {
                // �������ڽ����쳣
                System.out.println("���ڽ����쳣��" + e.getMessage());
            }
        });
        panel.add(addStudent);

        // ������
        panel.add(new JTextField());
        panel.add(new JTextField());
        panel.add(new JTextField());
        panel.add(new JTextField());
        panel.add(new JTextField());
        panel.add(new JTextField());
        JButton editStudent = new JButton("�޸�ѧ��");
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

        // ������
        panel.add(new JTextField());
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());
        JButton deleteStudent = new JButton("ɾ��ѧ��");
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

        // ������
        panel.add(new JTextField());
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());
        JButton findStudent = new JButton("��ѯѧ��");
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

        // ��ӱ߿���
//        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        // ����ҳ���
        panel.setBorder(new EmptyBorder(0, 50, 0, 50));

        this.add(panel, BorderLayout.SOUTH);
    }

    private void getAllStudent() throws SQLException {
        Connection con = DataControl.openData();
        Statement sta = con.createStatement();

        String sql = "SELECT * FROM stuinfo";
        ResultSet rs = sta.executeQuery(sql);

        // ��ձ������
        tableModel.setRowCount(0);
        while (rs.next()) {
            // �ӽ�����л�ȡѧ����Ϣ
            String id = rs.getString("stu_id");
            String name = rs.getString("stu_name");
            String birthday = rs.getString("birthday");
            String sex = rs.getString("sex");
            String province = rs.getString("province");
            String homeAddress = rs.getString("city");

            // ��ѧ����Ϣ��ӵ���������ģ����
            Object[] rowData = {id, name, birthday, sex, province, homeAddress};
            tableModel.addRow(rowData);
        }

//        initCenter();
    }

    private void addStudents(String id, String name, String bir, String sex,
                             String pro, String city) throws SQLException, ParseException {

        if (id.trim().equals("")){
            System.out.println("���ʧ��, �����ѧ����ѧ�Ų���Ϊ��");
            return;
        }

        Connection con = DataControl.openData();

        // �������ڸ�ʽ
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

        System.out.println("�ɹ�������" + rows + "������");

        preparedStatement.close();
        con.close();
    }

    private void deleteStudents() throws SQLException {
        int[] selectRows = jTable.getSelectedRows();
        if (selectRows.length == 0) {
            System.out.println("����ѡ��Ҫɾ������");
            return;
        }
        Connection con = DataControl.openData();
        Statement stm = con.createStatement();
        // ����������ȡ����(��ȡѧ�������е�����)
        int columnIndex = jTable.getColumnModel().getColumnIndex("ѧ��");
        int count = 0;
        for(int x:selectRows){
            String id = jTable.getValueAt(x, columnIndex).toString();  // ��ȡ����ѧ����id
            String sqlDelete = "DELETE FROM stuinfo WHERE stu_id = " + id;
            count += stm.executeUpdate(sqlDelete);
        }

        // �Ƴ���ѡ����
        for (int i = selectRows.length - 1; i >= 0; i--){
            tableModel.removeRow(selectRows[i]);
        }

        System.out.println("�ɹ�ɾ��" + count + "������");
    }

    private void modifyStudents(String newId, String newName, String newBir, String newSex,
                                String newPro, String newCity) throws SQLException, ParseException {

        if (newId.trim().equals("")) {
            System.out.println("�޸�ʧ��, �޸ĺ��ѧ�Ų���Ϊ��");
            return;
        }

        // ��ȡ��ѡ����
        int selectStudent = jTable.getSelectedRow();
        if (selectStudent == -1) {
            System.out.println("�޸�ʧ�ܣ�����ѡ��Ҫ�޸ĵ�����");
            return;
        }
        // ��ȡѧ��������
        int columnIndex = jTable.getColumnModel().getColumnIndex("ѧ��");
        // ��ȡ��ѡ��ѧ����ѧ����Ϣ
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

        System.out.println("�ɹ��޸�ѧ��Ϊ:" + id + "��ѧ����Ϣ");
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
            // �ӽ�����л�ȡѧ����Ϣ
            String id = rs.getString("stu_id");
            String name = rs.getString("stu_name");
            String birthday = rs.getString("birthday");
            String sex = rs.getString("sex");
            String province = rs.getString("province");
            String homeAddress = rs.getString("city");

            // ��ѧ����Ϣ��ӵ���������ģ����
            Object[] rowData = {id, name, birthday, sex, province, homeAddress};
            tableModel.addRow(rowData);
        }

        sta.close();
        con.close();
    }
}
