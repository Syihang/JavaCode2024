package Expriment12;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class StudentGradeGUI extends JFrame {

    private DefaultTableModel model;

    public StudentGradeGUI() {
        setTitle("学生姓名与成绩");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        // 初始化表格模型
        model = new DefaultTableModel(new Object[]{"姓名", "数学成绩", "语文成绩", "英语成绩", "化学成绩", "物理成绩", "总分"}, 0);
        loadFromTxt(); // 从文本文件中读取数据
        JTable table = new JTable(model);

        // 创建滚动面板，并将表格添加到面板中
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // 创建按钮面板
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("添加学生信息");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });
        JButton deleteButton = new JButton("删除学生信息");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteStudent(table);
            }
        });
        JButton calculateButton = new JButton("计算总分");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateTotalScore(table);
            }
        });
        JButton saveButton = new JButton("保存到txt");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveToTxt();
            }
        });
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(calculateButton);
        buttonPanel.add(saveButton);

        // 将按钮面板添加到窗口底部
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void addStudent() {
        String name = JOptionPane.showInputDialog(this, "请输入学生姓名:");
        if (name != null && !name.trim().isEmpty()) {
            model.addRow(new Object[]{name, 0, 0, 0, 0, 0, 0});
        } else {
            JOptionPane.showMessageDialog(this, "请输入有效的姓名!");
        }
    }

    private void deleteStudent(JTable table) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            model.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "请选择要删除的行!");
        }
    }

    private void calculateTotalScore(JTable table) {
        int rowCount = table.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            int totalScore = 0;
            for (int j = 1; j < table.getColumnCount() - 1; j++) {
                totalScore += Integer.parseInt(table.getValueAt(i, j).toString());
            }
            table.setValueAt(totalScore, i, table.getColumnCount() - 1);
        }
    }

    private void saveToTxt() {
        File file = new File("D:\\Java\\JavaCode2024\\CourseWork\\src\\Expriment12\\text.txt");
        try (PrintWriter writer = new PrintWriter(file)) {
            for (int i = 0; i < model.getRowCount(); i++) {
                StringBuilder line = new StringBuilder();
                for (int j = 0; j < model.getColumnCount(); j++) {
                    line.append(model.getValueAt(i, j));
                    if (j < model.getColumnCount() - 1) {
                        line.append("\t");
                    }
                }
                writer.println(line);
            }
            JOptionPane.showMessageDialog(this, "数据保存成功!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "保存失败: " + e.getMessage());
        }
    }

    private void loadFromTxt() {
        File file = new File("D:\\Java\\JavaCode2024\\CourseWork\\src\\Expriment12\\text.txt");
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split("\t");
                    model.addRow(data);
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "加载失败: " + e.getMessage());
            }
        }
    }

}
