package exam02;

import java.util.function.IntPredicate;

public class Ex03 {
    public static void main(String[] args) {
        IntPredicate cond1 = x -> x >= 10;
        IntPredicate cond2 = x -> x < 100;
        IntPredicate cond3 = cond1.and(cond2); // x>= 10 && x < 100
    }
}
