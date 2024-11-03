# Short - Circuit

<aside>
💡

**단축 평가는 && 와 || 의평가 방식에 따라 표현하는 방법을 최적화 시킴**

</aside>

```jsx
const a = false || "마라탕" ;

const user = !!prompt("유저의 이름 입력") || "Guest";
alert(`${user}님 환영합니다.`);

const pw = prompt("비밀번호를 입력하세요");
const result = pw == "1234";
result && alert("로그인 축하");

```