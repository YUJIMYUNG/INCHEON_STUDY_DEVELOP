# JSX

<aside>
💡

JSX(Javascript + XML) 문법으로 React에서 HTML과 Javascript를 결합하여 UI설계

</aside>

- **JSX(JavaScript XML)**는 React에서 사용되는 문법으로, JavaScript코드 안에 HTML과 유사한 구문을 작성할 수 있게 해줌
- JSX는 **JavaScript 코드로 변환**되어 브라우저에서 실행됨
- React 컴포넌트에서 UI를 선언적으로 표현하는데 사용됨

## JSX문법의 기본 규칙

---

1. 태그 구조
    1. JSX에서는 단일 루트 태그로 감싸기
    2. 여러 태그를 사용할 경우 부모 태그로 감싸야 함

1. Javascript표현식 사용 
    1. JSX 내부에서 `{}`  를 사용하여 JavaScript 표현식을 삽입 가능
    
    ```jsx
    const name = "Alice";
    const element = <h1>Hello, {name}!</h1>; // Hello, Alice!
    ```
    
    - 변수 : `{name}`
    - 함수 호출 : `{getUserName()}`
    - 삼항 연산자 : `{isLoggedIn ? “welcome” : “Sing in”}`

1. 속성 사용
    1. class 대신 className 사용
    2. style 속성에서는 오브젝트 타입 사용 

1. 리스트 렌더링
    1. 열 데이터를 반복 렌더링할 때는 `map()`을 사용

1. 이벤트 처리
    1. 이벤트 핸들러는 함수로 전환

### 요약

1. JSX는 HTML과 JavaScript를 결합한 문법으로, React 에서 UI선언적으로 설계
2. JSX내부에서 JavaScript 표현식은 `{}` 으로 감싸서 사용
3. 태그 구조는 단일 루트 태그로 감싸야 하며, 속성은 camelCase로 작성
4. 조건부 렌더링, 리스트 렌더링, 이벤트 처리 등 다양한 UI동작을 쉽게 구현 가능