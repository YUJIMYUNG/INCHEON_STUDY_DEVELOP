package exam01;

public class Ex11 {
    public static void main(String[] args) {
        int[][] nums = {{10, 20, 30}, {40, 50, 60}};
        System.out.printf("nums.length=%d%n", nums.length); // 행 : 2
        System.out.printf("nums[0].length=%d%n", nums[0].length); // 0행 열의 갯수
        System.out.printf("nums[1].length=%d%n", nums[1].length); // 1행의 열의 갯수

        for (int i = 0; i < nums.length; i++) { // 행. 0. 1
            for (int j = 0; j < nums[i].length; j++) { // 각 행의 열, 0, 1, 2
                System.out.printf("%d행, %d열 = %d%n", i, j, nums[i][j]);
            }
        }
    }
}
