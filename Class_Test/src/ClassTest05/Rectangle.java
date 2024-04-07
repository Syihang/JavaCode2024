// 计科22101班 苏一行
package ClassTest05;

public class Rectangle extends Shape{

    // 成员变量
    float length, wide;

    @Override
    public float getArea() {
        return length * wide;
    }

    // 成员方法

    public Rectangle(float length, float wide) {
        this.length = length;
        this.wide = wide;
    }

    public Rectangle(String color, float length, float wide) {
        super(color);
        this.length = length;
        this.wide = wide;
    }
}
