package Expriment12;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Table extends JFrame {



    public Table(){

        initFrame();

    }

    private void initFrame() {

        this.setTitle("简单表格");

        Object[] columnTitle = {"姓名", "语文", "数学", "英语", "物理", "化学", "生物"};

        ArrayList<Object[]> tableData = new ArrayList<>(Arrays.asList(
                new Object[]{"张三", 110, 120, 95, 89, 95, 97},
                new Object[]{"李四", 97, 100, 88, 69, 91, 89},
                new Object[]{"王五", 100, 96, 72, 79, 75, 87}
        ));

//        JTable table = new JTable(tableData, columnTitle);
    }


}
