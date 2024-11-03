# Data Type & Type Casting

<aside>
💡

**자바스크립트의 데이터 타입은 문자, 숫자, 불리언이 있다.**

**타입 캐스팅은 타입을 바꿔주는 역할이다.**

</aside>

## Data Type

---

<aside>
💡

**자바스크립트 기본 타입 : 문자, 숫자, 불리언, null, undefined ↔ 참조타입**

</aside>

- 문자 타입(String) : “(쌍따옴)”, ‘(홑따옴)’
- 숫자 타입(Number) : 1, 3.14, 1004,…
- 불리언타입(Boolean) : true, false
- Undefined : 초기화 되지 않는 값
- Null : 데이터가 없음(무)

## Type Casting

---

<aside>
💡

**타입을 바꿔주는 역할에서 `명시적 타입 캐스팅`과 `암묵적 타입 캐스팅`으로 나뉜다.**

</aside>

```jsx
// 1. 문자화
1. String(100) -> "100" // 명시적 타입
2. + 문자열 -> 모든 문자열 바뀜 // 암묵적 타입 

// 2. 숫자화
1. Number("100") -> 100 // 명시적 타입 
2. parseInt("100.5") -> 100(정수)  // 명시적 타입 
3. parseFloat("100.5") -> 100.5(실수) // 명시적 타입
4. + "1" -> 1(숫자) // 암묵적 타입

// 3. 불리언화
1. Boolean("파인애플 피자") -> true // 명시적 타입
2. !!데이터 -> truthy & falsy // 암묵적 타입

```

- Truthy & Falsy Value
    - 0, “”, null, undefined, NaN : Falsy value
    - 1