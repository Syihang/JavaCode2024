package test2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class MyJFrame extends JFrame {

    private JTextArea textArea; // ���һ���ı�����
    private JLabel aboutLabel; // ���һ��������ʾ������Ϣ�ı�ǩ

    public MyJFrame() {
        // ��ʼ������
        initJFrame();
        // ��ʼ���˵�
        initJMenuBar();
    }

    private void initJFrame() {
        setTitle("��һ�еļ��±�");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initJMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        // �ļ��˵�
        JMenu fileMenu = new JMenu("�ļ�");
        JMenuItem newItem = new JMenuItem("�½�");
        JMenuItem openItem = new JMenuItem("��");
        JMenuItem saveItem = new JMenuItem("����");
        JMenuItem exitItem = new JMenuItem("�˳�");

        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        // �½�����
        newItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNewTextArea();
            }
        });

        // �򿪹���
        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFile();
            }
        });

        // ���湦��
        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveFile();
            }
        });

        // �˳�����
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // �����˵�
        JMenu helpMenu = new JMenu("����");
        JMenuItem aboutItem = new JMenuItem("����");

        helpMenu.add(aboutItem);

        // ���ڹ���
        aboutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAboutInfo(); // ��ʾ������Ϣ
            }
        });

        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);
    }

    private void createNewTextArea() {
        if (textArea != null) {
            getContentPane().remove(textArea); // �Ƴ��Ѵ��ڵ��ı�����
        }
        textArea = new JTextArea();
        textArea.setLineWrap(true); // �Զ�����
        JScrollPane scrollPane = new JScrollPane(textArea); // ��ӹ�����
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // ʼ����ʾ��ֱ������
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); // ʼ����ʾˮƽ������
        getContentPane().add(scrollPane, BorderLayout.CENTER); // ���ı�������ӵ�������������
        revalidate(); // ������֤�Ը��²���
        repaint(); // �ػ����
    }

    private void openFile() {
        createNewTextArea();
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                StringBuilder content = new StringBuilder();
                BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
                reader.close();
                textArea.setText(content.toString()); // ��ʾ�򿪵��ļ�����
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "�޷����ļ�", "����", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void saveFile() {
        if (textArea != null) {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showSaveDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(selectedFile));
                    writer.write(textArea.getText()); // ���ı���������д���ļ�
                    writer.close();
                    JOptionPane.showMessageDialog(this, "����ɹ�", "��ʾ", JOptionPane.INFORMATION_MESSAGE); // ��ʾ����ɹ�
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "����ʧ��", "����", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private void showAboutInfo() {
        if (textArea != null) {
            getContentPane().remove(textArea); // �Ƴ��Ѵ��ڵ��ı�����
            textArea = null;
        }
        if (aboutLabel != null) {
            getContentPane().remove(aboutLabel); // �Ƴ��Ѵ��ڵĹ�����Ϣ��ǩ
        }
        aboutLabel = new JLabel("�ƿ�22101 ��һ��");
        aboutLabel.setHorizontalAlignment(SwingConstants.CENTER); // ˮƽ����
        aboutLabel.setVerticalAlignment(SwingConstants.CENTER); // ��ֱ����
        getContentPane().add(aboutLabel, BorderLayout.CENTER); // ��������Ϣ��ǩ��ӵ�������������
        revalidate(); // ������֤�Ը��²���
        repaint(); // �ػ����
    }

}
