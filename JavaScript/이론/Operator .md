# Operator

<aside>
💡

**데이터을 처리하는 토큰들**

</aside>

```jsx
// 수리 연산자 [+, -, *, /, %]

const a = 1 + 1; // 2[더하기]
const a1 = 1 - 2; // -1 [빼기]
const a2 = 2 * 2; // 4 [곱하기]
const a3 = 2 ** 3; // 8 [제곱]
const a4 = 3 / 2; // 1.5[ 나누기]
const a5 = 3 % 2; // 1 [나머지]

// 문자열 연결 연산자, 부호 반대 연산자
const b1 = 1 + "2"; // 12 [문자 연결]
const b2 = -100; // -100 [부호 반대]

// 대입 연산자
const c = "마라탕"

// 비교 연산자 [<, >, <=, >=, ==, ===, !=] -> boolean 타입
const d = 3 > 0; // true
const d1 = 3 < 5; // true
const d2 = 3 >= 0; // true
const d3 = 3 <= 5; // true
const d4 = 10 == 11; // false;
const d5 = 10 === 10 // true; [타입이 같나? 여부도 확인함]
const d6 = 3 != 1 // true;

 // 논리 연산자[&&(and), ||(or), !(not)]
 // && : 모두 true 이어야 true
 const e = 5 > 3 && 3 > 1 // true
 const e1 = 3 > 0 && 0 > 1 // false
 
 // || : 하나라도 true 이면 true
 const e2 = 3 < 0 || 2 < 0 || 1 < 0 || 0 <= 0 //true
 
 // ! : 불리언 반대 부호
 const e3 = !(3 > 0) // false
 const e4 = !(0 > 0) // true
 const e5 = !0 // true
 
 const test = !(5 < 3) || !(2 < 4)
 const test1 = (5 >= 3) && (2 >= 4) //드모르간 법칙 적용
 //코드는 positive하게 작성해야지 눈에 잘 들어온다. clean code
 
 // 삼항 연산자 [ ? : ]
 const f = 조건 ? 참 : 거짓
 const f1 = 5 > 3 ? "떡볶이" : "순대"; // 떡볶이
 const f2 =  5 < 3 "떡볶이" : "순대"; // 순대
 
 //typeof 연산자
 const g = typeof "" // String
 const g1 = typeof !"" // Boolean
```