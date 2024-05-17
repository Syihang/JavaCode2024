package GUI.Layout;

import javax.swing.*;

public class FlowLayout {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello World");
        frame.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 30, 30));
        JButton button = null;

        for (int i = 0; i < 9; i ++){
            button = new JButton("°´Å¥" + i);
            frame.add(button);
        }
        frame.setSize(280, 250);
        frame.setVisible(true);
    }
}
