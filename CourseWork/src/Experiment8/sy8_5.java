package Experiment8;

public class sy8_5 {
    public static void main(String args[]) {
        String n1 = "aaa";
        String n2 = "ccc", n3 = "a";

        System.out.println("��ȡ�ַ���n1�ĳ��ȣ�" + n1.length());
        System.out.println("��ȡ�ַ���n1���±�λ��Ϊ2���ַ���" + n1.charAt(2));
        System.out.println("��n1�±�Ϊ1��λ�ÿ�ʼ��ȡn1���Ӵ���" + n1.substring(1));
        System.out.println("�Ƚ��ַ���n1��n2�Ƿ���ͬ��" + n1.equals(n2));
        // �����ֵ���˳��Ƚ������ַ����е�һ������ͬλ���ַ��Ĵ�С�����������ֵ�������ַ�������򷵻�0
        System.out.println("�ַ����ȽϽ����" + n1.compareTo(n2));
        System.out.println("�ַ����ȽϽ����" + n1.compareTo(n3));
    }
}
