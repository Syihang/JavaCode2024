package ArrayList;

import java.util.ArrayList;

public class test01 {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("123");
        list.add("222");
        list.add("333");

        System.out.println(list);

        list.remove(0);

        System.out.println(list);

        boolean result = list.remove("222");

        System.out.println(result +  " " + list);

        list.add("123");
        list.add("222");
        list.add("333");

        System.out.println(list);

        for (String str:list) {
            System.out.println(str);
        }

    }
}
