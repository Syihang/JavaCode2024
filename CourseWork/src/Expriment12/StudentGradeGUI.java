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
        setTitle("ѧ��������ɼ�");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        // ��ʼ�����ģ��
        model = new DefaultTableModel(new Object[]{"����", "��ѧ�ɼ�", "���ĳɼ�", "Ӣ��ɼ�", "��ѧ�ɼ�", "����ɼ�", "�ܷ�"}, 0);
        loadFromTxt(); // ���ı��ļ��ж�ȡ����
        JTable table = new JTable(model);

        // ����������壬���������ӵ������
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // ������ť���
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("���ѧ����Ϣ");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });
        JButton deleteButton = new JButton("ɾ��ѧ����Ϣ");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteStudent(table);
            }
        });
        JButton calculateButton = new JButton("�����ܷ�");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateTotalScore(table);
            }
        });
        JButton saveButton = new JButton("���浽txt");
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

        // ����ť�����ӵ����ڵײ�
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void addStudent() {
        String name = JOptionPane.showInputDialog(this, "������ѧ������:");
        if (name != null && !name.trim().isEmpty()) {
            model.addRow(new Object[]{name, 0, 0, 0, 0, 0, 0});
        } else {
            JOptionPane.showMessageDialog(this, "��������Ч������!");
        }
    }

    private void deleteStudent(JTable table) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            model.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "��ѡ��Ҫɾ������!");
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
            JOptionPane.showMessageDialog(this, "���ݱ���ɹ�!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "����ʧ��: " + e.getMessage());
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
                JOptionPane.showMessageDialog(this, "����ʧ��: " + e.getMessage());
            }
        }
    }

}
