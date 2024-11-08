# 반복문

## while문

1. while

```java
while(조건식) {
	//조건식이 참일때 반복 수행되는 코드
}
```

- 횟수가 정해진 조건식의 필수요소 : 초기값, 조건식, 증감식

1. do~while

```java
do {
	//조건식이 참일때 반복 수행되는 코드
	//조건식이 거짓이더라도 한 번은 무조건 실행
} while(조건식)
```

- while문은 조건식이 false일 경우에는 조건문의 코드블럭을 수행하지 않지만 do~while문은 무조건 한 번은 실행하고 조건문에 대한 true, false를 구분한 다음에 조건식을 수행한다.

## for문

- 반복 횟수가 있는 경우 자주 사용
- 초기값, 조건식, 증감식 : 횟수가 있는 반복의 필수 요소
- 횟수, 순서는 index라고 하여 관례적으로 초기화식 변수명은 i부터 시작하고 다음 알파벳부터 순서대로 사용하게 된다. ex) i, j, k, l….

```java
for ( 초기화식 ; 조건식 ; 증감식 ) {
	// 조건식이 참일 때 반복 수행되는 코드
	continue; //  이후의 문장은 수행하지 않고 for문의 처음으로 돌아가 증감식 수행
	break; // 문장 수행 멈추기
```

## 중첩 반복문

- 반복문 안에 반복문

```java
//구구단 출력

public class Ex07 {
    public static void main(String[] args) {

        for(int i = 2 ; i <= 9 ; i++){
            System.out.println("--- " + i + "단 ----");
            for(int j = 1; j <= 9; j++){
                System.out.println(i + "X" + j + "=" + (i*j));
            }
        }
    }
}
```
