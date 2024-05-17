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
        // 设置尺寸、标题、居中、关闭模式
        this.setSize(350, 150);
        this.setTitle("用户登录");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // 设置布局管理器
        this.setLayout(new BorderLayout());
        // 禁止调整窗口大小
        this.setResizable(false);
    }

    private void initPanel() {
        // 创建一个Panel面板, 并指定其内部布局为二行三列
        Panel topPanel = new Panel();
        topPanel.setLayout(new GridLayout(2, 3));

        JLabel jLabel1 = new JLabel("用户名", JLabel.CENTER);
        JLabel jLabel2 = new JLabel("密  码", JLabel.CENTER);

        JTextField jTextField = new JTextField(12);
        JPasswordField jPasswordField = new JPasswordField(8);

        JLabel jLabel3 = new JLabel("用户注册", JLabel.CENTER);
        JLabel jLabel4 = new JLabel("找回密码", JLabel.CENTER);

        topPanel.add(jLabel1);
        topPanel.add(jTextField);
        topPanel.add(jLabel3);

        topPanel.add(jLabel2);
        topPanel.add(jPasswordField);
        topPanel.add(jLabel4);

        this.add(topPanel, BorderLayout.PAGE_START);

        // 添加按钮并设置属性
        JButton bt1 = new JButton("登录");
        JButton bt2 = new JButton("取消");
        JPanel p2 = new JPanel();
        p2.add(bt1);
        p2.add(bt2);
        this.add(p2,BorderLayout.PAGE_END);

        bt1.addActionListener(e -> {
            if (jTextField.getText().equals(userName) && new String(jPasswordField.getPassword()).equals(passWord)){
                JDialog jDialog = new JDialog(this,"登录成功");
                jDialog.setSize(200, 80);
                jDialog.setLocationRelativeTo(null);

                JLabel jLabel = new JLabel("登录成功, 正在跳转登录界面...");

                jDialog.add(jLabel);

                jDialog.setVisible(true);
            }
            else{
                JDialog jDialog = new JDialog(this,"登录失败");
                jDialog.setSize(200, 80);
                jDialog.setLocationRelativeTo(null);

                JLabel jLabel = new JLabel("登录失败, 用户名或密码错误...");

                jDialog.add(jLabel);

                jDialog.setVisible(true);
            }
        });

        bt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JDialog jDialog = new JDialog();
                jDialog.setTitle("提示信息");
                jDialog.setSize(300, 150);
                jDialog.setLocationRelativeTo(null);
                jDialog.setLayout(new BorderLayout()); // 设置对话框的布局管理器为边界布局

                // 添加图标
                JLabel jL1 = new JLabel();   // 创建一个标签用于显示图标
                ImageIcon imageIcon = new ImageIcon("CourseWork\\src\\Experiment11\\icon.png");
                Image image = imageIcon.getImage();
                // 获取图标的 Image 对象，并进行缩放
                image = image.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
                imageIcon.setImage(image);
                jL1.setIcon(imageIcon); // 设置标签的图标

                JPanel p1 = new JPanel();
                JLabel jL2 = new JLabel("你选择了退出登录，是否真的退出？");
                p1.add(jL1);
                p1.add(jL2);
                // 创建两个按钮并添加到面板中
                JButton bt1 = new JButton("是");
                JButton bt2 = new JButton("否");
                JPanel p2 = new JPanel();
                p2.add(bt1);
                p2.add(bt2);

                jDialog.add(p1,BorderLayout.PAGE_START); // 将包含图标和文本的面板添加到对话框的顶部
                jDialog.add(p2,BorderLayout.PAGE_END); // 将按钮面板添加到对话框的底部
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
