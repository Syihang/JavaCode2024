package test2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class MyJFrame extends JFrame {

    private JTextArea textArea; // 添加一个文本区域
    private JLabel aboutLabel; // 添加一个用于显示关于信息的标签

    public MyJFrame() {
        // 初始化界面
        initJFrame();
        // 初始化菜单
        initJMenuBar();
    }

    private void initJFrame() {
        setTitle("苏一行的记事本");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initJMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        // 文件菜单
        JMenu fileMenu = new JMenu("文件");
        JMenuItem newItem = new JMenuItem("新建");
        JMenuItem openItem = new JMenuItem("打开");
        JMenuItem saveItem = new JMenuItem("保存");
        JMenuItem exitItem = new JMenuItem("退出");

        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        // 新建功能
        newItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNewTextArea();
            }
        });

        // 打开功能
        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFile();
            }
        });

        // 保存功能
        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveFile();
            }
        });

        // 退出功能
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // 帮助菜单
        JMenu helpMenu = new JMenu("帮助");
        JMenuItem aboutItem = new JMenuItem("关于");

        helpMenu.add(aboutItem);

        // 关于功能
        aboutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAboutInfo(); // 显示关于信息
            }
        });

        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);
    }

    private void createNewTextArea() {
        if (textArea != null) {
            getContentPane().remove(textArea); // 移除已存在的文本区域
        }
        textArea = new JTextArea();
        textArea.setLineWrap(true); // 自动换行
        JScrollPane scrollPane = new JScrollPane(textArea); // 添加滚动条
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // 始终显示垂直滚动条
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); // 始终显示水平滚动条
        getContentPane().add(scrollPane, BorderLayout.CENTER); // 将文本区域添加到内容面板的中央
        revalidate(); // 重新验证以更新布局
        repaint(); // 重绘界面
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
                textArea.setText(content.toString()); // 显示打开的文件内容
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "无法打开文件", "错误", JOptionPane.ERROR_MESSAGE);
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
                    writer.write(textArea.getText()); // 将文本区域内容写入文件
                    writer.close();
                    JOptionPane.showMessageDialog(this, "保存成功", "提示", JOptionPane.INFORMATION_MESSAGE); // 提示保存成功
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "保存失败", "错误", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private void showAboutInfo() {
        if (textArea != null) {
            getContentPane().remove(textArea); // 移除已存在的文本区域
            textArea = null;
        }
        if (aboutLabel != null) {
            getContentPane().remove(aboutLabel); // 移除已存在的关于信息标签
        }
        aboutLabel = new JLabel("计科22101 苏一行");
        aboutLabel.setHorizontalAlignment(SwingConstants.CENTER); // 水平居中
        aboutLabel.setVerticalAlignment(SwingConstants.CENTER); // 垂直居中
        getContentPane().add(aboutLabel, BorderLayout.CENTER); // 将关于信息标签添加到内容面板的中央
        revalidate(); // 重新验证以更新布局
        repaint(); // 重绘界面
    }

}
