package Experiment7.expe1;

class MyDate {
    int year, month, day;

    void set(int y, int m, int d) {
        try {
            if (m < 1 || m > 12) throw new Exception("�·ݴ���");
            year = y;
            month = m;
            day = d;
        } catch (Exception e) {
            this.year = 2000;
            this.month = 1;
            this.day = 1;
            System.out.println(e.getMessage()); //����쳣��Ϣ
            System.out.println("\n���ڴ���");
        }
    }

    public String toString() {
        return year + "��" + month + "��" + day + "��";
    }
}

public class MyDateTest {
    public static void main(String args[]) {
        MyDate d1 = new MyDate();
        d1.set(2013, 17, 16);
        System.out.println("�����ú�����Ϊ��" + d1);
    }
}
