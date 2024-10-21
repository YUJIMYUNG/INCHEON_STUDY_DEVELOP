package exam01;

public class Ex04 {
    public static void main(String[] args) {
        // int[] nums = new int[]{10, 20, 30, 40}; // 배열 선언과 동시에 초기화
        // int[] nums = {10, 20, 30, 40}; //위가 공식 문법이지만 동일하게 동작함

        // int[] nums;
        // nums = {10, 20, 30, 40} ; 은 불가능

        int[] nums;
        nums = new int[] {10, 20, 30, 40}; //선언 하고나서 변수를 입력할때에는 공식 문법으로 사용해야함

//        System.out.println(nums[0]);
//        System.out.println(nums[1]);
//        System.out.println(nums[2]);
//        System.out.println(nums[3]);


        System.out.println(nums); // 배열 공간이 시작되는 시작 지점 주소, 참조 변수

    }
}
