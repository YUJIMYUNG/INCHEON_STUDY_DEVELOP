# 열거형, 애너테이션

> 열거형이란?
> 특수 목적 클래스
> 상수만을 열거하기 위한 클래스

## 열거형 정의와 사용

```java
enum 클래스명 {
	상수, 상수, 상수 ...
}
```

```java
public enum Transportation {
    BUS,
    SUBWAY,
    TAXI
}

==

public abstract class Transportation extends java.lang.Enum<Transportation> {
	public static final Transportation BUS = new Transportation(){};
	public static final Transportation SUBWAY = new Transportation(){};
	public static final Transportation TAXI = new Transportation(){};

	private Transportation(..){} // 객체를 여러개 만들 수 있으면 Enum상수로써 역할이 불가
	// 상수는 유일무이 해야한다!
}

// enum 상수의 비교 == (주소)
```

## 모든 열거형의 상위 클래스

### 컴파일러가 자동으로 추가해주는 메서드

- static T static valueOf(String name) : 문자열 → enum상수로 변환
- static T[] values() : enum 상수에 정의된 모든 상수를 배열 형태로 반환

### Enum클래스에 정의된 메서드

- String name(): 상수명을 문자열로 반환
  - 자바 객체인 enum 상수 → 문자열로 변경 → 다른 플랫폼에 전달하는 목적
    ```java
    static Enum.valueOf(Class class, String name)
    // 다른 플랫폼 -> 문자열 -> 자바 객체 enum 상수로 변환
    ```
- int ordinal() : 상수가 정의된 순서 번호
  - 내부에서만 주로 사용!(정의된 위치를 바꾸면 숫자가 변경 된다!)
- String toString() : 상수의 이름을 반환
  - name() 메서드는 재정의 불가능 - 상수의 이름을 명확하게 반환
  - toString()은 기본값은 있으나 재정의 하고 다른 용도로 사용할 수 있다.

## 애너테이션(annotation)

> 애너테이션이란?
> 주석, 주해 라는 뜻으로 정보 전달을 목적으로 한다. 정보 전달 대상도 중요!

### 표준 애너테이션

- JDK에 기본 포함된 애너테이션
- @Override : 정보 전달 대상은 컴파일러, 재 정의된 메서드라는 정보를 전달한다.
- @Deprecated : 추후 제거될 가능성이 있으므로 사용을 자제하라는 정보를 전달한다.
- @SupperessWarring : 경고 출력 배제
- @FucntionalInterface

### 메타 애너테이션

> 참고)
> 메타 인지? 지식의 지식 → 지식을 만들 수 있는 지식

- 애너테이션을 정의할 때 사용되는 애너테이션
- @Target : 애노테이션을 적용할 대상
  - ElementType
- @Retention : 정보를 전달하는 시점
  - RetentionPolicy
    - SOURCE : 자바(java)파일에는 애노테이션 정의가 유지, 컴파일된 파일(class)에서는 제거, 컴파일러가 정보를 확인
    - CLASS : 기본값. 자바(java)파일에서도 애노테이션 정의 유지, 컴파일된 파일(class)에서도 유지. 정보 전달을 하지 않음(사용을 거의 하지 않는다.)
    - RUNTIME : 자바(java)파일에서도 애노테이션 정의 유지, 컴파일된 파일(class)에서도 유지. 실행 중에 정보가 전달 된다.

### 사용자 정의 애너테이션

- 애너테이션 정보 확인 : Class 클래스 객체를 통해서 확인 가능!
- 애너테이션 정의 : 컴파일시 다음처럼 변환
  ```java
  public @interface MyAnno{

  }

  ->

  public interface MyAnno dentends java.lang.annotation.Annotation{

  }
  ```
