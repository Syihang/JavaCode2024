package Experiment11;

import javax.swing.*;
import java.awt.*;

public class WindowColor extends JFrame {

    public WindowColor(){
        initJframe();
        initJScorllPane();
        // 显示窗口
        this.setVisible(true);
    }

    private void initJframe() {
        // 设置界面的宽高
        this.setSize(400, 300);
        // 设置界面标题
        this.setTitle("操作事件");
        // 界面置顶设置
        this.setAlwaysOnTop(true);
        // 设置界面居中
        this.setLocationRelativeTo(null);
        // 设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initJScorllPane(){
        JScrollPane pa = new JScrollPane();
        // 设置面板滚动条为总是显示
        pa.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        // 创建一个文本框
        JTextArea showText = new JTextArea(10,30);

        // 在文本框内添加文本
        showText.append("字体颜色");

        // 设置文本框内容是否可以编辑
        showText.setEditable(true);
        // 将文本框添加到面板中
        pa.setViewportView(showText);

        // 添加普通面板
        Panel p = new Panel();

        JButton bt1 = new JButton("设置字体颜色");
        // 把按钮添加到面板中
        p.add(bt1);

        // 设置pa在顶部，p在底部
        this.add(pa, BorderLayout.PAGE_START);
        this.add(p, BorderLayout.PAGE_END);

        bt1.addActionListener(e->{
            Color textColor = showText.getForeground();
            if (textColor.equals(Color.RED)){
                showText.setForeground(Color.BLACK); // 将文本颜色设置为黑色
            }
            else{
                showText.setForeground(Color.RED); // 将文本颜色设置为红色
            }
        });
    }

}

