package Test01;

import javax.swing.*;
import java.awt.*;

public class SwingTest01 {

     public static void main(String[] args) {
          Frame jFrame = new Frame();

          // �������
          Panel panel = new Panel();

          // ���ò���
          jFrame.setLayout(null);

          // ��������
          jFrame.setBounds(50, 50, 500, 500);
          jFrame.setBackground(new Color(33, 42, 33));

          // ����panel����
          panel.setBounds(50, 50, 30, 30);
          panel.setBackground(new Color(35, 248, 216, 255));

          jFrame.add(panel);
          jFrame.setVisible(true);
     }


}
