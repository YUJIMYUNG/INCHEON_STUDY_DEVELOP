# Input / Output & Variable

<aside>
💡

**입력과 출력하는 문법과 Variable 이라는 문법 배우기**

</aside>

## Input / Output

---

- Input
    - prompt(”메세지”);
- Output
    - alert(”메세지”); : 경고나 알림으로 사용
    - confirm(”메세지”); : 문구를 보고 yes or no 를 사용
    - console.log(”메세지); : 로그에 메세지를 출력

## Variable(변수)

---

<aside>
💡

**변수는 데이터를 저장하고 참조하기 위해 사용되는 저장 공간**

</aside>

- why?
    
    인간은 연산(뇌)과 기억(뇌)을 동시에 한다.
    
    컴퓨터는 연산(cpu)과 기억(ram)을 따로한다.
    

```java
const 별명 = 데이터 ;
```

- const(변경 불가능) / let(변경 가능) : 변수를 선언 해주는 약속어
- 변수명 규칙
    - 숫자로 시작 불가능 ex) const 1coffee ❌
    - 약속어로 변수명 불가능 ex) const const❌
    - 특수문자 불가능. 단 $와 _(언더바) 제외 ex) const coffee!❌
    - 변수명 중복 불가능
- 변수명 약속
    - 의미 있는 단어로 작성 ex) const food = “기아셀토스”;❌
    - 소문자로 작성
    - 영어로 작성 지향
    - 두 단어 합쳐
        - 스네이크 이름 짓기 : const ice_americano
        - 카멜 이름 짓기  : const iceAmericano