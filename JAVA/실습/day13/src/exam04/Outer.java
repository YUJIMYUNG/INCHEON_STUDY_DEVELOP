package exam04;

public class Outer {
    public Calculator method(int num3){ // 매개변수에 컴파일러가 기본적으로 상수화 시킴
        // Calculator cal2 = new Calculator() { 변수를 굳이 선언하지 안고
        return new Calculator() {
            public int add(int num1, int num2){
                // num3 = 40; final num3 -> 데이터 영역 공간 할당
                // 지역 변수의 상수화 - 값을 제거하지 않을 목적
                return num1 + num2 + num3;
            }
        };

        //return cal2;

//        int result = cal.add(10, 20);
//        System.out.println(result);
    }
}
