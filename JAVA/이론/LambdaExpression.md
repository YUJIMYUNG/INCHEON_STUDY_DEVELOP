# 람다식

> 람다식이란? 
메서드(함수)를 하나의 식으로 표현
사용자 정의. 일회용 목적으로 사용하기 위해(단일성) 사용하는 기능
> 

### 함수형 프로그래밍

- 일등함수 :
    - 변수와 함수를 동등하게 취급, 함수는 값으로 사용될 수 있다.
    - 자바는 함수가 값으로 사용될 수 없다! - 진짜함수, 실행코드
    - 함수가 값으로 사용될 수 있는 대표적인 프로그래밍 언어 → JavaScript
- 함수란 ?
    - 하나의 기능(단일기능)
    - 사용자 정의 기능, 필요에 의해서 생성하고 다쓰면 버리는 일회용 객체
- 함수를 값으로 사용
    - 매개변수 : 사용자 정의 기능
    - 반환값 : 클로저

### 자바의 함수

- 자바의 함수는 값으로 사용할 수 없다.
- 인터페이스의 객체가 되는 조건을 이용한다.
- 형식을 단순화 함

### 람다식 문법

1. 접근제어자, 반환값 타입, 함수명을 생략
2. 매개변수 정이 부분과 함수 구현 부분({})

### 람다식 사용하기

- 함수형 인터페이스
    - @FunctionallInterface
        - 함수형 인터페이스 / 함수형 프로그래밍을 위한 인터페이스
        - 단일기능을 정의하기 위한 목적
        - 추상 메서드를 한개만 정의할 수 있고 이 형식을 체크
        

### java.util.function 패키지

- 많이 쓰는 함수의 유형을 인터페이스로 정의한다.
- 매개변수가 1개
    1. 매개변수 X, 반환값 O
        
        ```java
        Supplier <R>
        	R get();
        ```
        
    2. 매개변수 1, 반환값 X
        
        ```java
        Consumer<T>
        	void accept(T t);
        ```
        
    3. 매개변수 1, 반환값 O
        
        ```java
        Function<T, R>
        	R apply(T t);
        ```
        
    4. 매개변수 1, 반환값 : 논리값(true, false) - 판별식
        
        ```java
        Predicate<T>
        	boolean test(T t);
        ```
        

- 매개변수가 2개 - Bi 접두어
    1. 매개변수 2개, 반환값 X
    
    ```java
    BiConsumer<T, U> 
    	void accept(T t, U u);
    ```
    
    1. 매개변수 2개, 반환 O
    
    ```java
    BiFunction<T, U, R>
    	R apply(T t, U u);
    ```
    
    1. 매개변수 2개, 반환값 boolean
    
    ```java
    BiPredicate<T, U>
    	boolean test(T t, U u);
    ```
    

- 매개변수와 반환값 자료형이 동일한 경우
    1. 매개변수 1개
    
    ```java
    UnaryOperator<T>
    	T apply(T t);
    ```
    
    1. 매개변수 2개
    
    ```java
    BinaryOperator<T>
    	T apply(T t1, T t2);
    ```
    

- 기본 자료형 함수형 인터페이스 : 연산의 효율성을 위해서(연산은 기본 자료형으로 하는게 가장 좋다!)
- 기본자료형 Function<R> : 매개변수 - 기본자료형, 반환값 - R

```java
IntFunction<R>
	R apply(int t);
```

- To기본자료형Function<T> : 매개변수 - T, 반환값이 기본자료형

```java
DoubleFunction<T>
	double applyAsDouble(T t);
```

- 기본자료형1To기본자료형2Function : 매개변수 - 기본자료형1, 반환값 - 기본자료형2

```java
IntToLongFunction
	long applyAsLong(int t);
```

## Function의 합성과 Predicate의 결합

- A.andThen(B) → A와 B를 결합해서 새로운 함수
- B.compose(A) → A와 B를 결합해서 새로운 함수

- Pridecate
    
    ```java
    and(Pridecate) // AND연산
    or(Pridecate) // OR연산
    ```