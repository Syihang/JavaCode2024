package TestClass01;

public class Table {
    private int length;
    private int wide;
    private int high;
    String material;

    public void show() {
        System.out.println("���ӵĳ�Ϊ��" + getLength());
        System.out.println("���ӵĿ�Ϊ��" + getWide());
        System.out.println("���ӵĸ�Ϊ��" + getHigh());
        System.out.println("���ӵĲ���Ϊ��" + getMaterial());
        System.out.println("���ӵı����Ϊ��" + (getLength() * getWide()));
    }

    public Table( String material, int length, int wide, int high) {
        this.length = length;
        this.wide = wide;
        this.high = high;
        this.material = material;
    }

    public Table() {}

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWide() {
        return wide;
    }

    public void setWide(int wide) {
        this.wide = wide;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
