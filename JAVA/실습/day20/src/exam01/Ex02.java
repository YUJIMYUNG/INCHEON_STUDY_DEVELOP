package exam01;

import java.util.Arrays;
import java.util.function.IntPredicate;

public class Ex02 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

//        IntPredicate conds = new IntPredicate() {
//            @Override
//            public boolean test(int value) {
//                System.out.println(value);
//                return value % 2 == 1;
//            }
//        };
//
//        int sum = Arrays.stream(nums).filter(conds).sum();
//
//        System.out.println(sum);

        int sum = Arrays.stream(nums).filter(new IntPredicate() {
            @Override
            public boolean test(int value) { // 사용자 정의 기능
                return value % 2 == 1;
            }
        }).sum();
        System.out.println(sum);

        int sum2 = Arrays.stream(nums).filter(x -> x % 2 == 1).sum();
        System.out.println(sum2);
    }
}
