package exam01;

public class Ex05 {
    public static void main(String[] args) {
        int[] nums1 = {10, 20, 30, 40}; // nums1은 배열 공간의 시작 주소
        int[] nums2 = nums1; // nums1이 가지고 있는 값을 nums2에 대입
        nums2[1] = 22;
        System.out.printf("nums1[1]=%d%n", nums1[1]); // 22출력
        System.out.printf("nums2[1]=%d%n", nums2[1]); // 22출력
     // 주소를 참고해서 자원을 접근하는 변수 - 참조변수


    }
}
