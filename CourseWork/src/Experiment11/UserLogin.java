package Experiment11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserLogin extends JFrame {

    static String userName = "suyihang";
    static String passWord = "123456";

    public UserLogin(){
        initFrame();
        initPanel();
        this.setVisible(true);
    }

    private void initFrame() {
        // ���óߴ硢���⡢���С��ر�ģʽ
        this.setSize(350, 150);
        this.setTitle("�û���¼");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // ���ò��ֹ�����
        this.setLayout(new BorderLayout());
        // ��ֹ�������ڴ�С
        this.setResizable(false);
    }

    private void initPanel() {
        // ����һ��Panel���, ��ָ�����ڲ�����Ϊ��������
        Panel topPanel = new Panel();
        topPanel.setLayout(new GridLayout(2, 3));

        JLabel jLabel1 = new JLabel("�û���", JLabel.CENTER);
        JLabel jLabel2 = new JLabel("��  ��", JLabel.CENTER);

        JTextField jTextField = new JTextField(12);
        JPasswordField jPasswordField = new JPasswordField(8);

        JLabel jLabel3 = new JLabel("�û�ע��", JLabel.CENTER);
        JLabel jLabel4 = new JLabel("�һ�����", JLabel.CENTER);

        topPanel.add(jLabel1);
        topPanel.add(jTextField);
        topPanel.add(jLabel3);

        topPanel.add(jLabel2);
        topPanel.add(jPasswordField);
        topPanel.add(jLabel4);

        this.add(topPanel, BorderLayout.PAGE_START);

        // ��Ӱ�ť����������
        JButton bt1 = new JButton("��¼");
        JButton bt2 = new JButton("ȡ��");
        JPanel p2 = new JPanel();
        p2.add(bt1);
        p2.add(bt2);
        this.add(p2,BorderLayout.PAGE_END);

        bt1.addActionListener(e -> {
            if (jTextField.getText().equals(userName) && new String(jPasswordField.getPassword()).equals(passWord)){
                JDialog jDialog = new JDialog(this,"��¼�ɹ�");
                jDialog.setSize(200, 80);
                jDialog.setLocationRelativeTo(null);

                JLabel jLabel = new JLabel("��¼�ɹ�, ������ת��¼����...");

                jDialog.add(jLabel);

                jDialog.setVisible(true);
            }
            else{
                JDialog jDialog = new JDialog(this,"��¼ʧ��");
                jDialog.setSize(200, 80);
                jDialog.setLocationRelativeTo(null);

                JLabel jLabel = new JLabel("��¼ʧ��, �û������������...");

                jDialog.add(jLabel);

                jDialog.setVisible(true);
            }
        });

        bt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JDialog jDialog = new JDialog();
                jDialog.setTitle("��ʾ��Ϣ");
                jDialog.setSize(300, 150);
                jDialog.setLocationRelativeTo(null);
                jDialog.setLayout(new BorderLayout()); // ���öԻ���Ĳ��ֹ�����Ϊ�߽粼��

                // ���ͼ��
                JLabel jL1 = new JLabel();   // ����һ����ǩ������ʾͼ��
                ImageIcon imageIcon = new ImageIcon("CourseWork\\src\\Experiment11\\icon.png");
                Image image = imageIcon.getImage();
                // ��ȡͼ��� Image ���󣬲���������
                image = image.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
                imageIcon.setImage(image);
                jL1.setIcon(imageIcon); // ���ñ�ǩ��ͼ��

                JPanel p1 = new JPanel();
                JLabel jL2 = new JLabel("��ѡ�����˳���¼���Ƿ�����˳���");
                p1.add(jL1);
                p1.add(jL2);
                // ����������ť����ӵ������
                JButton bt1 = new JButton("��");
                JButton bt2 = new JButton("��");
                JPanel p2 = new JPanel();
                p2.add(bt1);
                p2.add(bt2);

                jDialog.add(p1,BorderLayout.PAGE_START); // ������ͼ����ı��������ӵ��Ի���Ķ���
                jDialog.add(p2,BorderLayout.PAGE_END); // ����ť�����ӵ��Ի���ĵײ�
                jDialog.setVisible(true);


                bt1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                });

                bt2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jDialog.dispose();
                    }
                });
            }
        });
    }

}
