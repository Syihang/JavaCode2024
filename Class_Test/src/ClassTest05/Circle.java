package ClassTest05;

public class Circle extends Shape{

    // 成员变量
    float r;

    // 成员方法

    public Circle(float r) {
        this.r = r;
    }

    public Circle(String color, float r) {
        super(color);
        this.r = r;
    }

    @Override
    public float getArea() {
        return 3.14f * r * r;
    }
}
