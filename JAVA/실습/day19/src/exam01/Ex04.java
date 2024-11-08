package exam01;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Ex04 {
    public static void main(String[] args) {
        List<String> items = new ArrayList<>();
        items.add("항목1");
        items.add("항목2");
        items.add("항목3");
        items.add("항목4");
        items.add("항목5");

        items.forEach(System.out::println);


        ListIterator<String> iter = items.listIterator();
        while (iter.hasNext()) { // 순방향 조회
            String item = iter.next();
            int index = iter.nextIndex();
            System.out.printf("item = %s, index = %d%n", item, index);
        }

        while (iter.hasPrevious()) { // 역방향 조회
            String item = iter.previous();
            int index = iter.previousIndex();
            System.out.printf("item = %s, index = %d%n", item, index);
        }

    }
}
