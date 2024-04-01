package ArrayList;

import java.util.ArrayList;

public class Test03 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            list.add(i);
        }

        System.out.println(list);
    }
}
