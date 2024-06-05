package Test01;

import javax.swing.*;
import java.awt.*;

public class SwingTest01 {

     public static void main(String[] args) {
          Frame jFrame = new Frame();

          // 设置面版
          Panel panel = new Panel();

          // 设置布局
          jFrame.setLayout(null);

          // 设置坐标
          jFrame.setBounds(50, 50, 500, 500);
          jFrame.setBackground(new Color(33, 42, 33));

          // 设置panel坐标
          panel.setBounds(50, 50, 30, 30);
          panel.setBackground(new Color(35, 248, 216, 255));

          jFrame.add(panel);
          jFrame.setVisible(true);
     }


}
