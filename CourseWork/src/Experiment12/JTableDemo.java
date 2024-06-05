package Experiment12;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
public class JTableDemo extends JFrame{
    Object[][] data= {};//表格的数据
    String[] columnNames = {"课程代码","课程名称","学分","学时"};//表格的列
    DefaultTableModel tableModel;//表格的数据模型
    JTable table; //表格
    JButton addButton=new JButton("增加");
    JButton editButton=new JButton("修改");
    JButton deleteButton=new JButton("删除");
    public JTableDemo() {
        JFrame frame=this;
        setTitle("表格示例");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(400,300);
        Container contentPane=this.getContentPane();
        tableModel=new DefaultTableModel(data,columnNames);//创建数据模型
        table=new JTable(tableModel);//创建表格,关联数据模型
        RowSorter sorter=new TableRowSorter(tableModel);//创建表格行排序
        table.setRowSorter(sorter);//设置表格行排序
        JPanel panel=new JPanel();
        panel.add(addButton);
        panel.add(editButton);
        panel.add(deleteButton);
        contentPane.add(new JLabel("课程信息"),BorderLayout.NORTH);
        contentPane.add(new JScrollPane(table),BorderLayout.CENTER);
        contentPane.add(panel,BorderLayout.SOUTH);
        //增加按钮注册事件监听器
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AddDialog(frame,tableModel,-1);
            }
        });
        //修改按钮注册事件监听器
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int row=table.getSelectedRow();//获取被选中的行号
                if(row!=-1) {
                    new AddDialog(frame,tableModel,row);
                }
            }
        });
        //删除按钮注册事件监听器
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int[] rows=table.getSelectedRows();//获取所有被选中的行号
                if(rows.length>0) {
                    for(int i=0;i<rows.length;i++) {
                        tableModel.removeRow(rows[i]);//删除选中的行
                    }
                }
            }
        });
        setVisible(true);
    }
    public static void main(String[] args) {
        JTableDemo frame=new JTableDemo();
    }
}
//对话框
class AddDialog extends JDialog{
    JTextField codeField=new JTextField(10);
    JTextField nameField=new JTextField(10);
    JTextField scoreField=new JTextField(10);
    JTextField hoursField=new JTextField(10);
    JButton clearButton=new JButton("清空");
    JButton saveButton=new JButton("保存");
    public AddDialog(JFrame owner,DefaultTableModel model,int row) {
        super(owner,true);
        if(row==-1) {
            setTitle("增加课程");
        }else {
            setTitle("修改课程");
            codeField.setText((String)model.getValueAt(row,0));
            nameField.setText((String)model.getValueAt(row,1));
            scoreField.setText((String)model.getValueAt(row,2));
            hoursField.setText((String)model.getValueAt(row,3));
        }
        setSize(400,150);
        setLocationRelativeTo(null);//居中显示
        setResizable(false);//禁用最大化
        JPanel panel1=new JPanel();
        panel1.setLayout(new GridLayout(2,2));
        JPanel panel11=new JPanel();
        JPanel panel12=new JPanel();
        JPanel panel13=new JPanel();
        JPanel panel14=new JPanel();
        panel11.add(new JLabel("课程代码："));
        panel11.add(codeField);
        panel12.add(new JLabel("课程名称："));
        panel12.add(nameField);
        panel13.add(new JLabel("课程学分："));
        panel13.add(scoreField);
        panel14.add(new JLabel("课程学时："));
        panel14.add(hoursField);
        panel1.add(panel11);panel1.add(panel12);
        panel1.add(panel13);panel1.add(panel14);
        JPanel panel2=new JPanel();
        panel2.add(clearButton);
        panel2.add(saveButton);
        this.add(panel1,BorderLayout.CENTER);
        this.add(panel2,BorderLayout.SOUTH);
        //保存按钮注册事件监听器
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(!codeField.getText().equals("")&&
                        !nameField.getText().equals("")&&
                        !scoreField.getText().equals("")&&
                        !hoursField.getText().equals("")) {
                    Object rowData[]= {codeField.getText(),
                            nameField.getText(),
                            scoreField.getText(),
                            hoursField.getText()};
                    if(row==-1) {//增加课程
                        model.addRow(rowData);
                    }else {//修改课程信息
                        model.setValueAt(codeField.getText(), row, 0);
                        model.setValueAt(nameField.getText(), row, 1);
                        model.setValueAt(scoreField.getText(), row, 2);
                        model.setValueAt(hoursField.getText(), row, 3);
                    }
                }
            }
        });
        //清空按钮注册事件监听器
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                codeField.setText("");
                nameField.setText("");
                scoreField.setText("");
                hoursField.setText("");
            }
        });
        this.setVisible(true);
    }
}
