package ClassTest05;

public abstract class Shape {

    // 成员变量
    String color;

    public Shape() {
        color = "黑色";
    }

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void show() {
        System.out.println("颜色为：" + color);
    }

    public abstract float getArea();
}
