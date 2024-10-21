package exam01;

public class Ex10 {
    public static void main(String[] args) {
        int[][] nums = new int[2][3]; // 2행, 3열
        System.out.println(nums); // 배열 주소 값

        nums[0][0] = 10;
        nums[0][1] = 20;
        nums[0][2] = 30;

        // 1행
        nums[1][0] = 40;
        nums[1][1] = 50;
        nums[1][2] = 60;
    }
}
