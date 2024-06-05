package Test01;

import javax.swing.*;
import java.awt.*;

public class SwingLayout {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();

        JButton east = new JButton("east");
        JButton west = new JButton("west");
        JButton south = new JButton("south");
        JButton north = new JButton("borth");
        JButton center = new JButton("center");

        jFrame.add(east, BorderLayout.EAST);
        jFrame.add(west, BorderLayout.WEST);
        jFrame.add(north, BorderLayout.NORTH);
        jFrame.add(south, BorderLayout.SOUTH);
        jFrame.add(center, BorderLayout.CENTER);

        jFrame.setBounds(100, 100, 300, 300);

        jFrame.setVisible(true);
    }
}
