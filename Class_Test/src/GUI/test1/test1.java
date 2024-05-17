package GUI.test1;

import javax.swing.*;

public class test1 {

    public static void main(String[] args) {
        creatJFram();

        new MyJFram();
    }


    public static void creatJFram() {

        JFrame jf = new JFrame("ÎÒµÄ´°¿Ú");
        jf.setSize(400, 300);
        jf.setLocation(150, 500);

        jf.setVisible(true);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JDialog jd = new JDialog(jf);

        jd.setSize(300, 300);

        jd.setLocation(200, 300);

        jd.setTitle("JDialog");

        jd.setVisible(true);
    }
}
