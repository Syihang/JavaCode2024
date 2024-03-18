package TestClass01;

public class Table {
    private int length;
    private int wide;
    private int high;
    String material;

    public void show() {
        System.out.println("桌子的长为：" + getLength());
        System.out.println("桌子的宽为：" + getWide());
        System.out.println("桌子的高为：" + getHigh());
        System.out.println("桌子的材质为：" + getMaterial());
        System.out.println("桌子的表面积为：" + (getLength() * getWide()));
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
