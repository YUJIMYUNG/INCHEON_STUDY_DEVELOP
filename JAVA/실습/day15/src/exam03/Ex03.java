package exam03;

public class Ex03 {
    public static void main(String[] args) {
        String str = "ABC";
        System.out.printf("str의 주소 : %d%n", System.identityHashCode(str));

        str += "DEF";
        System.out.printf("str의 주소 : %d%n", System.identityHashCode(str));

        str += "GHI";
        System.out.printf("str의 주소 : %d%n", System.identityHashCode(str));

        System.out.println(str);

        String str2 = "ABCDEFGHI";

        System.out.println(str == str2); // false
        System.out.println(str.equals(str2)); // true;
    }
}
