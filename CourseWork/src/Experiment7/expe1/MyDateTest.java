package Experiment7.expe1;

class MyDate {
    int year, month, day;

    void set(int y, int m, int d) {
        try {
            if (m < 1 || m > 12) throw new Exception("月份错误！");
            year = y;
            month = m;
            day = d;
        } catch (Exception e) {
            this.year = 2000;
            this.month = 1;
            this.day = 1;
            System.out.println(e.getMessage()); //输出异常信息
            System.out.println("\n日期错误");
        }
    }

    public String toString() {
        return year + "年" + month + "月" + day + "日";
    }
}

public class MyDateTest {
    public static void main(String args[]) {
        MyDate d1 = new MyDate();
        d1.set(2013, 17, 16);
        System.out.println("经设置后日期为：" + d1);
    }
}
