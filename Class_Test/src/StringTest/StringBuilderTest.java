package StringTest;
// 常用语添加和反转字符串操作
public class StringBuilderTest {
    // 常用语添加和反转字符串操作
    public static void main(String[] args) {
        String str = "1234321";
        String result = new StringBuilder().append(str).reverse().toString();

        System.out.println(str.equals(result));
    }
}
