# java.lang 패키지

<aside>
💡

기본적으로 많이 사용하는 클래스들이 포함되어있다.

</aside>

### 컴파일러가 자동으로 코드를 추가해주는 부분

1. `import java.lang.*`
2. `extends java.lang.Object` → 모든 클래스는 Object 하위 클래스
3. 기본생성자 
4. `super()`
5. 인터페이스 메서드 앞에 `public abstract`
6. 인터페이스 정의된 변수, `public static final` 
7. 지역 내부 클래스, 지역 변수의 상수화, `final`
8. 참조 변수를 출력했을 때 자동으로 `참조변수.toString()` 이 추가됨

### toString() 메서드

```java
public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }
    
// 참고)
Object
	ClasS<?> getClass()
// 클래스 내부의 인스턴스 메서드에서 Class 클래스 객체를 접근
// Class 클래스 객체 : 클래스 정보가 담겨 있는 객체
```

### equals() 메서드

```java
public boolean equals(Object obj){
	return(this == obj);
	// 동일성 비교(주소) : ==
}

// 비교
// 동일성 : 물리적으로 동일한 개체
// 동등성 : 동등한 가치(가치 판단 필요) -> 개발자마다 다른 기준으로 동등성을 판단

String str = "값";
String str2 = new String("...");
```

- 동일성 비교(주소) : ==
- 동등성 비교 : `boolean equals() and int hashCode()` 재정의한다.
    - 중복을 제거할 경우 동등성 비교를 내부에서 많이 하게된다.

### hashCode() 메서드

```java
	java.util.Objects : 
		hash(Object... values)
```

## String 클래스

### String을 선언하는 두 가지 방법

1. String str = “문자열”;
2. String str = new String(”문자열”);

### String 클래스의 final char[] 변수

- 최근 : final byte[]
- 문자열은 불변하는 특징
- 매번 문자열 추가 → 새로운 객체가 만들어진다 → 성능 저하

### StringBuffer와 StringBuilder 클래스 활용하기

- 버퍼 : 임시 메모리(byte[])
- StringBuffer : 쓰레드 안정성(동시성 작업시 안전)
- StringBuilder : 쓰레드 안정성 X (동시성 작업시 영향을 받는다.

## Wrapper 클래스

> **기본 자료형을 위한 클래스**
기본자료형 - 정수, 실수, 논리, 문자 
즉, 재료가 되는 값을 말한다.
> 

### Wrapper 클래스의 종류

- 기본 자료형의 값을 처리하는 편의 기능 클래스
- byte → Byte 클래스
- short → Short 클래스
- int → Integer 클래스
- long → Long 클래스
- float → Float 클래스
- double → Double 클래스
- boolean → Boolean 클래스
- char → Character 클래스

```java
class Integer {
	...
	private final int value;
	...
}
```

## Class 클래스

> 모든 클래스의 정적변수 class
Object 클래스의 정의된 getClass() : 인스턴스 메서드 내부에서 현재 생성된 객체의 Class 클래스 객체를 접근할 때
> 

### Class.forName()을 사용해 동적 로딩하기

- 일반적으로 클래스의 자원은 로드 시에 클래스 로더에 의해서 다 초기에 구성
- 원격에서 제공 받은 클래스 자원을 실행 과정중에 로드 하는 경우