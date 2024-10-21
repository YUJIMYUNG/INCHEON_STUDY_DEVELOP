package exam01;

public class Ex02 {
    public static void main(String[] args) {
        int[] nums = new int[4] ; // int 변수 4개 - 동일 자료형
        // nums[0], nums[1]  -> 접근할 때에는 자료형 생략
        nums[0] = 10; // 0번째에 있는 변수에 10을 대입
        nums[1] = 20;
        nums[2] = 30;
        nums[3] = 40;

        System.out.println(nums[0]);
        System.out.println(nums[1]);
        System.out.println(nums[2]);
        System.out.println(nums[3]);

    }
}
