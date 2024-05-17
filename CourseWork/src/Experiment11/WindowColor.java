package Experiment11;

import javax.swing.*;
import java.awt.*;

public class WindowColor extends JFrame {

    public WindowColor(){
        initJframe();
        initJScorllPane();
        // ��ʾ����
        this.setVisible(true);
    }

    private void initJframe() {
        // ���ý���Ŀ��
        this.setSize(400, 300);
        // ���ý������
        this.setTitle("�����¼�");
        // �����ö�����
        this.setAlwaysOnTop(true);
        // ���ý������
        this.setLocationRelativeTo(null);
        // ���ùر�ģʽ
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initJScorllPane(){
        JScrollPane pa = new JScrollPane();
        // ������������Ϊ������ʾ
        pa.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        // ����һ���ı���
        JTextArea showText = new JTextArea(10,30);

        // ���ı���������ı�
        showText.append("������ɫ");

        // �����ı��������Ƿ���Ա༭
        showText.setEditable(true);
        // ���ı�����ӵ������
        pa.setViewportView(showText);

        // �����ͨ���
        Panel p = new Panel();

        JButton bt1 = new JButton("����������ɫ");
        // �Ѱ�ť��ӵ������
        p.add(bt1);

        // ����pa�ڶ�����p�ڵײ�
        this.add(pa, BorderLayout.PAGE_START);
        this.add(p, BorderLayout.PAGE_END);

        bt1.addActionListener(e->{
            Color textColor = showText.getForeground();
            if (textColor.equals(Color.RED)){
                showText.setForeground(Color.BLACK); // ���ı���ɫ����Ϊ��ɫ
            }
            else{
                showText.setForeground(Color.RED); // ���ı���ɫ����Ϊ��ɫ
            }
        });
    }

}

