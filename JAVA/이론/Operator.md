# 연산자

### 항과 연산자

<aside>
💡

연산에 사용하는 값을 항(operand)이라고하고 연산에 사용하는 기호를 연산자(operator)라고 한다.

</aside>

- 연산자는 항의 개수에 따라 단항 영산자, 이항 연산자, 삼항 연산자로 나눌 수 있다.

1. 대입 연산자

- 변수에 값을 대입하는 연산자
- 대입 연산자는 이항 연산자 중 우선순위가 가장 낮은 연산자이다.

```java
int num = 10; //오른쪽 값을 왼쪽 변수에 저장(대입)

int result = 10 + 20 + 30; //오른쪽에 연산 결과가 result 변수에 저장(대입)
```

1. 부호 연산자(단항 연산)

- 부호 연산자는 +, - 두가지가 있다.
- - : 부호 반전 (양수 → 음수, 음수→ 양수)

```java
public class Ex01 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = -num1; // -10

        System.out.println(num2); //-10 출력 됨

        int num3 = -num2;

        System.out.println(num3); //10 출력됨
    }
}
```

1. 산술 연산자

- +(더하기), -(빼기), \*(곱하기), /(나누기), %(나머지)
  - %(나머지) 연산자의 특징 : 규칙성(균등 배분), 나누는 수보다 작은 수가 반복 됨
- 산술 연산자의 우선순위는 일반 수학의 산술연산과 같다. ()→ 연산자 우선 순위를 강제 적용함

1. 증가감소 연산자

- 단항 연산
- 1씩 증가(++), 1씩 감소(—)
- ex ) num++; , num—;, ++num;, —num;

```java
public class Ex03 {
    public static void main(String[] args) {
        int num1 = 10;
        num1++; // 1씩 증가
        num1 = num1 + 1; // => num1++; 과 같음
        System.out.println(num1); //출력 12


        int num2 = 20;
        ++num2; //21출력
    }
}

public class Ex04 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = num1++; // ++연산자가 num1뒤에 있으면 ++연산자를 뒤에 오는 값에 대입한다.
                           // 1) 대입(=) : 10, 2) ++(증가연산) : 11
        System.out.println(num2); //10출력
        System.out.println(num1); //11출력

    }
}

public class Ex05 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = ++num1; // 1) num1에 ++증가연산되고 2)증가 된 num1값이 num2로 대입
        System.out.println(num1); //11출력
        System.out.println(num2); //11출력
    }
}
```

1. 관계(비교) 연산자

- > (크다), <(작다), >=(크거나 같다), <=(작거나 같다)
- ==(같다 : 값의 같음 여부X, 자원의 주소가 동일한지를 판단), !=(다르다 : 자원의 주소가 동일하지 않는지를 판단.) 두가지의 연산 결과는 참(true), 거짓(false)로 나온다.

1. 논리 연산자

- 연산에 필요한 값? 논리값(true, false)
- AND연산(&&) : 모두 참일때 참으로 결과가 나오는 연산
  - true && true = true
  - false && false = true
  - true && false = false
  - false && true = false
- OR연산(||) : 하나라도 참이면 결과가 참으로 나오는 연산
  - true && true = true
  - false && false = false
  - true && false = true
  - false && true = true
- NOT연산(!) : 단일 연산자. 부정을 의미함
  - !true → false
  - !false → true
- 단락회로 평가 : 논리 연산자의 연산은 판별이 목적! 이미 판별된 상황이면 연산이 종료됨

1. 복합 대입 연산자

- 대입 연산자(=), 다른 연산자(산술연산자 -,+,\*,/,%,비트연산자…)를 복합하는 연산자

```java
int num = 10;
num = num + 2; // num += 2; 2씩 증가
num = num * 2; // num *= 2; 2씩 곱하기
num = num / 2; // num *= 2; 2씩 나누기
```

1. 조건 연산자(삼항조건연산자)

- 조건식은 참, 거짓을 판별하는 연산식(참, 거짓)
- (1항)조건식 ? (2항)참일 때 : (3항)거짓일 때

1. 연산자 우선순위

- 대입 연산자 < 논리 연산자 < 비교 연산자 < 소괄호식(…), […]
