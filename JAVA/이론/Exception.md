# 예외처리

<aside>
💡

오류(Error) : 시스템의 오류, JVM 오류, 통제 불가 오류
예외(Exception) : 코드 상의 오류 → 통제 가능한 오류
**서비스의 중단을 막기 위한 목적으로 예외 처리를 한다!**

</aside>

## 예외 클래스의 종류

### Exception

- Exception을 바로 상속 받은 예외 클래스
- RuntimeException을 중간에 상속 받은 예외 클래스
  - Runtime : 실행
  - 예) java.lang.ArithmethicException : 0으로 나눌 때 발생
- 예외가 발생하더라도 컴파일 실행하고 class 파일 생성 함
- 예외의 체크는 실행 중 체크, 실행이 되려면 class 파일이 필요함 (컴파일이 된다)
- 유연한 예외, 형식을 매우 중시

> 참고)
> 예외 발생 : trow 예외 객체;
> 예외, 오류 : 원인을 확인하는 것이 중요

## 예외 처리하기

### try-catch문

```java
try {
 // 예외가 발생할 가능성이 있는 코드
 } catch (처리할 예외 타입 e) {
 // 예외 발생시 처리할 코드
 }


 // 다중 예외처리

 //방법1)
 try {
 // 예외가 발생할 가능성이 있는 코드
 } catch (처리할 예외 타입1 | 처리 예외 타입2 e) {
 // 예외 발생시 처리할 코드
 }

 //방법2)
  try {
 // 예외가 발생할 가능성이 있는 코드
 } catch (공통부모를 상속받고있다면 그 클래스 e) {
 // 예외 발생시 처리할 코드
 }

 //방법3)
  try {
 // 예외가 발생할 가능성이 있는 코드
 } catch (Exception e) {
 // 예외 발생시 처리할 코드
 }
```

### try-catch-finally문

- 자원을 소비하는 객체 - FileInputStream, FileOutputStream, Connection, PrepareStatement…
- 자원 해제 → 애플리케이션 종료시에 해제
- 서버? 종료X → 자원해제를 하지 않으면 메모리 부족 현상 발생
- 자원 해제를 적절하게 해야한다.(close()…)

```java
try{
} catch(...) {
} finally {
	// 예외가 발생하든 안하든 항상 실행되는 코디
	// return 하더라도 코드가 실행
}
```

### try-with-resources문

- JDK7에서 추가
- 자원 해제를 자동으로 함

```java
try(해제할 자원 객체; 해제할 자원 객체 ...) {
	// 예외가 발생할 가능성이 있는 코드
	} catch (처리할 예외 코드){
	 // 예외 발생시 처리할 코드
	}
```

## 예외 처리 미루기

### 예외 처리를 미루는 throws 사용하기

- 메서드를 호출 하는 쪽에서 예외 처리 전가
- 전가시키는 예외에 대에서 명시(throws) : 메서드 매개변수 뒤쪽에 throws 전가할 예외 작성
- Exception을 상속 받은 경우(RuntimeException이 없는 경우)

> **참고)**
> 스프링 프레임워크
> SQLException(Exception) → DataAccessException(RuntimeException)으로 변환

현장에서는 유연성이 중요!
RuntimeException 하위 클래스 형태로 사용자 정의 예외를 많이 정의

>
