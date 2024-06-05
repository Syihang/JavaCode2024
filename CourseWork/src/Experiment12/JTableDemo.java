package Experiment12;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
public class JTableDemo extends JFrame{
    Object[][] data= {};//��������
    String[] columnNames = {"�γ̴���","�γ�����","ѧ��","ѧʱ"};//������
    DefaultTableModel tableModel;//��������ģ��
    JTable table; //���
    JButton addButton=new JButton("����");
    JButton editButton=new JButton("�޸�");
    JButton deleteButton=new JButton("ɾ��");
    public JTableDemo() {
        JFrame frame=this;
        setTitle("���ʾ��");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(400,300);
        Container contentPane=this.getContentPane();
        tableModel=new DefaultTableModel(data,columnNames);//��������ģ��
        table=new JTable(tableModel);//�������,��������ģ��
        RowSorter sorter=new TableRowSorter(tableModel);//�������������
        table.setRowSorter(sorter);//���ñ��������
        JPanel panel=new JPanel();
        panel.add(addButton);
        panel.add(editButton);
        panel.add(deleteButton);
        contentPane.add(new JLabel("�γ���Ϣ"),BorderLayout.NORTH);
        contentPane.add(new JScrollPane(table),BorderLayout.CENTER);
        contentPane.add(panel,BorderLayout.SOUTH);
        //���Ӱ�ťע���¼�������
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AddDialog(frame,tableModel,-1);
            }
        });
        //�޸İ�ťע���¼�������
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int row=table.getSelectedRow();//��ȡ��ѡ�е��к�
                if(row!=-1) {
                    new AddDialog(frame,tableModel,row);
                }
            }
        });
        //ɾ����ťע���¼�������
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int[] rows=table.getSelectedRows();//��ȡ���б�ѡ�е��к�
                if(rows.length>0) {
                    for(int i=0;i<rows.length;i++) {
                        tableModel.removeRow(rows[i]);//ɾ��ѡ�е���
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
//�Ի���
class AddDialog extends JDialog{
    JTextField codeField=new JTextField(10);
    JTextField nameField=new JTextField(10);
    JTextField scoreField=new JTextField(10);
    JTextField hoursField=new JTextField(10);
    JButton clearButton=new JButton("���");
    JButton saveButton=new JButton("����");
    public AddDialog(JFrame owner,DefaultTableModel model,int row) {
        super(owner,true);
        if(row==-1) {
            setTitle("���ӿγ�");
        }else {
            setTitle("�޸Ŀγ�");
            codeField.setText((String)model.getValueAt(row,0));
            nameField.setText((String)model.getValueAt(row,1));
            scoreField.setText((String)model.getValueAt(row,2));
            hoursField.setText((String)model.getValueAt(row,3));
        }
        setSize(400,150);
        setLocationRelativeTo(null);//������ʾ
        setResizable(false);//�������
        JPanel panel1=new JPanel();
        panel1.setLayout(new GridLayout(2,2));
        JPanel panel11=new JPanel();
        JPanel panel12=new JPanel();
        JPanel panel13=new JPanel();
        JPanel panel14=new JPanel();
        panel11.add(new JLabel("�γ̴��룺"));
        panel11.add(codeField);
        panel12.add(new JLabel("�γ����ƣ�"));
        panel12.add(nameField);
        panel13.add(new JLabel("�γ�ѧ�֣�"));
        panel13.add(scoreField);
        panel14.add(new JLabel("�γ�ѧʱ��"));
        panel14.add(hoursField);
        panel1.add(panel11);panel1.add(panel12);
        panel1.add(panel13);panel1.add(panel14);
        JPanel panel2=new JPanel();
        panel2.add(clearButton);
        panel2.add(saveButton);
        this.add(panel1,BorderLayout.CENTER);
        this.add(panel2,BorderLayout.SOUTH);
        //���水ťע���¼�������
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
                    if(row==-1) {//���ӿγ�
                        model.addRow(rowData);
                    }else {//�޸Ŀγ���Ϣ
                        model.setValueAt(codeField.getText(), row, 0);
                        model.setValueAt(nameField.getText(), row, 1);
                        model.setValueAt(scoreField.getText(), row, 2);
                        model.setValueAt(hoursField.getText(), row, 3);
                    }
                }
            }
        });
        //��հ�ťע���¼�������
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
