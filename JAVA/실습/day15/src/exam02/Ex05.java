package exam02;

import java.util.List;

public class Ex05 {
    public static void main(String[] args) {
        List<String> items = List.of("ABC",
                new String("ABC"),
                new String("ABC"),
                "DEF",
                "GHI");
        System.out.println(items);

        List<String> items2 = items.stream().distinct().toList(); // distinct() : 중복제거
        System.out.println(items2);
    }
}
