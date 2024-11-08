package exam02;

import java.util.HashSet;

public class Ex01 {
    public static void main(String[] args) {
        HashSet<String> items = new HashSet<>();
        items.add("이름1");
        items.add("이름2");
        items.add("이름2");
        items.add("이름2");
        items.add("이름3");
        items.add("이름4");
        items.add("이름5");

        System.out.println(items);
    }
}
