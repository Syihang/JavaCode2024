package GUI.test1;

import javax.swing.*;
import java.awt.*;

public class MyJFram extends JFrame {
    MyJFram(){
        initJFrame();
    }

    private void initJFrame() {
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setTitle("Test");
        this.setLayout(null);

        JButton jb1 = new JButton("JButton1");
        jb1.setBounds(30, 30, 100, 50);
//        this.add(jb1);

        this.getContentPane().add(jb1);




        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }
}
