package exam03;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Ex01 {
    public static void main(String[] args) {
        HashMap<String, String> members = new HashMap<>();
        members.put("user01", "사용자01");
        members.put("user02", "사용자02");
        members.put("user03", "사용자03");

        Set<Map.Entry<String, String>> entries = members.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.printf("key = %s, value = %s%n", key, value);
        }

        members.put("user02", "(수정)사용자02"); // 기존에 있는 key이면 value값 변경됨
        members.remove("user02");

        //String userName = members.get("user02");
        String userName = members.getOrDefault("user02", "없음!");
        System.out.println(userName);
    }
}
