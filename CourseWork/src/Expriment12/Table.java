package Expriment12;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Table extends JFrame {



    public Table(){

        initFrame();

    }

    private void initFrame() {

        this.setTitle("�򵥱��");

        Object[] columnTitle = {"����", "����", "��ѧ", "Ӣ��", "����", "��ѧ", "����"};

        ArrayList<Object[]> tableData = new ArrayList<>(Arrays.asList(
                new Object[]{"����", 110, 120, 95, 89, 95, 97},
                new Object[]{"����", 97, 100, 88, 69, 91, 89},
                new Object[]{"����", 100, 96, 72, 79, 75, 87}
        ));

//        JTable table = new JTable(tableData, columnTitle);
    }


}
