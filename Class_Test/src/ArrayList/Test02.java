package ArrayList;

import java.util.ArrayList;
import java.util.StringJoiner;

public class Test02 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        list.add("eee");
        StringJoiner sj = new StringJoiner(",","[","]");
        for (String str:list) {
            sj.add(str);
        }

        System.out.println(sj.toString());
    }
}
