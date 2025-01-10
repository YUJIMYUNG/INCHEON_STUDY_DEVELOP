# Typescript 개론

<aside>
💡

**TypeScript는 Microsoft에서 개발한 오픈소스 프로그래밍 언어로, JavaSvript의 슈퍼셋(superset)[확장판]입니다.**

</aside>

[JavaScript With Syntax For Types.](https://www.typescriptlang.org/ko/)

## 타입스크립트 사용 이유

---

1. 타입에 대한 안정성 보장
2. 프로그램의 확장성 용이

## 타입스크립트 컴파일

---

- 웹 브라우저[HTML, CSS, JavaScript] ↔ React, TS
    1. 타입스크립트 설치 : `npm install -g typescript`
    2. 이 폴더에 타입스크립트 시작 : `npx tsc —init` 
    3. ts를 js로 바꿔는 방법 : `tsc(typescript complie) 해당파일명.ts`
- npx tsc 입력해야 타입스크립트가 자바스크립트로 번역이 됨

# Typescript 변수 선언
<aside>
💡

**TypeScript는 변수와 함수의 타입을 명확하게 정의할 수 있도록 지원합니다. 이를 통해 코드의 오류를 사전에 방지하고, 더 안전한 코드를 작성할 수 있습니다.**

</aside>

## Type Annotation

- 명시적으로 타입을 지정하기

```tsx
const num:number = 8;
const yesOrNo:boolean = true;
```

## 문법

---

```tsx
const name:타입 = 데이터;
```

## 예시

---

```tsx
//문자타입 만들기
const movie:string = "10";

//숫자타입
//불리언타입 만들기
const num:number = 8;
const yesOrNo:boolean = true;

//배열타입
const coffees: string[] = ["아메리카노", "라떼"];
const coffees1: Array<string> = ["디카페인", "고구마라떼"];

//숫자배열타입
const numList: number[] = [1, 2, 3];
//불리언배열타입
const booleanList: Array<boolean> = [true, false, false];

//오브젝트
const student: {name:string, age:number} = {
    name: "유지명",
    age : 23,
};

//latte 오브젝트 shots, kcal, ingredients
const latte: {shots:number, kcal:number, ingredidnts:string} = {
    shots: 2,
    kcal: 500,
    ingredidnts: "우유"
}

//car 오브젝트 배열
//name, model, engine{name,model,power}
const car:{
    name:string,
    model:string, 
    engine: {name:string, model:string, power:number}}[] = [
        {name:"테슬라", model:"y", engine:{name:"abc", model:"k1", power:100}},
        {name:"테슬라2", model:"x", engine:{name:"abc", model:"k1", power:100}},
    ];

//도너츠 오브젝트 배열
//이름, 칼로리, 성분, 오브젝트배열 {name, 함량}
const donuts:{name:string, kcal:number, ingredient:{name:string, content:number}[]}[] =[
    {name:"초코도넛", kcal:400, ingredient:[{name:"설탕", content:50}, {name:"초콜릿", content:20}]},
    {name:"딸기도넛", kcal:400, ingredient:[{name:"설탕", content:50}, {name:"딸기", content:20}]},
];
```

# Typescript 함수선언
<aside>
💡

**함수를 정의할 때는 매개변수의 타입과 리턴 값의 타입을 명시할 수 있습니다.**

</aside>

## 문법

```tsx
const func = (x:type, y:type)type => {
	returnType
}

const func1 = (x?:string) => 로직만들기 // x는 반환값일수도 있고 문자열일수도 있음

const func2 = (x:string="Guest") => 로직만들기 // x를 반환하면 자동으로 Geust 반환
```

- 타입 지정으로 인해서 자동 추론과 에러 방지
- 선택적/기본값 매개변수는 `?` 를 넣으면 기본값 채택

# Typescript 타입연산자

<aside>
💡

타입 연산자는 다양한 방식으로 타입을 조작하거나 결합해주는 연산자이다.

</aside>

## 유니언(Union) 연산자( `|` )

---

- 하나 이상의 타입 중 하나일 수 있음을 나타냄
    
    ```tsx
    type TypeA = string | number;
    
    const printId = (id:string | number) => {
    	console.log(`ID' : ${id}`)
    }
    ```
    

## 인터섹션(Intersection) 연산자(`&`)

---

- 여러 타입을 모두 만족하는 타입
- never타입 : 간접적인 에러를 나타냄
    
    ```tsx
    type TypeB = TypeA & TypeB;
    
    type Person = {name:string, age:number };
    type Student = {major:string, id:number, grad:number};
    type University = Person & Student;
    ```

## Typeof 연산자(`typeof`)

---

- 자바스크립트 기본 연산자
- 타입을 추출할 때 사용함
    
    ```tsx
    const person = {name:"홍길동", age:32}
    
    type Person = typeof person // {name:string, age:number}
    ```
    

## Keyof 연산자(`keyof`)

---

- 오브젝트 타입의 키를 유니온 타입으로 추출
- 오브젝트 타입의 키를 제한된 값으로 사용할 때 사용
- **함수의 매개변수 타입을 객체의 키로 제한할 때 사용**
    
    ```tsx
    type Person = { name:string, age:number, location?:string}
    
    keyof Person; //"name" | "age" | "location"
    ```
    

## 인덱스 시그니처

---

- 오브젝트의 키를 타입 정하기
    
    ```tsx
    type Pizza = { [index:string]:string }
    
    const cheesePizza:Pizza = { name:"치즈피자", price : "25000" }
    
    //예시문제
    type StudentMathScore = { [name:string]:number};
    
    const classOne:StudentMathScore = {
        kim: 50,
        lee: 50,
        park: 60
    }
    
    //영어점수
    type EngScore = {[name:string]:number};
    const classTwo:EngScore = {
        kim : 100,
        lee: 10,
        park : 40
    }
    
    //국어점수, 등급도 갖는 배열 형태의 오브젝트로 만들기
    type Grade = "A" | "B" | "C" | "D" | "F"; 
    //타입 안정성을 위해서 부분집합의 개념으로 넣기
    type KorScore = {[name:string]:number | Grade} & {grade:Grade};
    const classTree:KorScore[] = [
        { kim :30, grade:"F"},
        { lee :100, grade:"A"},
        { park :80, grade:"B"},
    ]
    
    ```
    

## In 연산자(`In`)

---

- in 연산자는 매핑 타입에서 사용함
- 오브젝트의 각 속성을 특정 타입 변환할 때 사용
    
    ```tsx
    type Keys = "option1" | "option2" | "option3"
    
    type Option = {
    	[key in Keys] : boolean
    }
    
    const option:Option = {option1 : true}
    const option1:Option = {option2: false}
    ```

# Typescript 타입 알리아스
<aside>
💡

**타입의 새로운 이름을 부여하는 방법**

</aside>

- 복잡한 타입을 간단하게 표현, 코드의 재사용성을 높인다.

## 문법

---

```tsx
type AliasName = ExistingType;

// 1. 기본 타입 알리아스
type ID = string | number;

// 2. 객체 타입 알리아스
type user = {name:string, age:number};

// 3. 함수 타입 알리아스
type GreetingFunc = (name:string) => {
	`${name}님 안녕하세요.`
}

//4. 인터섹션 타입 알리아스
type A = {name:string};
type B = {age:number};
type AC = A & B;

//5. 리터럴 타입 알리아스
type MainMenu = "빅맥" | "치즈" | "새우" | "불고기" | "상하이";
type SubMenu = "감튀" | "코우슬로" | "치즈스틱" | "양파튀김";
type DrinkMenu = "콜라" | "제로콜라" | "사이다" | "스프라이드" | "쥬스";
type Macdonald = {
    main: MainMenu,  sub:SubMenu, drink:DrinkMenu};
type MaksSet = (main: MainMenu,  sub:SubMenu, drink:DrinkMenu) => Macdonald;

const order: MaksSet = (main, sub, drink) => {
    return {main, sub, drink};
}

const myOrder = order("빅맥","양파튀김", "스프라이드");
```

# Typescript 제네릭

<aside>
💡

**제네릭 타입은 다양한 타입을 받아주는 연산자이다.**

</aside>

## 문법

---

```tsx
type AliasName<T> = 타입정의
```

- `AliasName`은 타입 별칭의 이름이다.
- `<T>`는 제네릭 파라미터로, 다양한 타입을 받을 수 있게 한다.
- `/* 타입 정의 */`  부분에 구체적인 타입을 정의한다.

## 여러 제너릭 문법

---

```tsx
type Pair<T, U> = {
    first:T,
    second:U
}

const test6:Pair<string, boolean> = {
    first:"김떙떙",
    second:false
}
```

## 제너릭 제약 조건

---

```tsx
type Job = "전사" | "궁수" | "마법사";
type NewJob = "성기사" | "무법자";
type Weapon = "검" | "활" | "지팡이";
type Armor = "갑옷" | "철갑옷";

type GameChar<T extends Job | NewJob, U extends Weapon, V extends Armor> = {
    job : T;
    weapon : U,
    armor : V
}

const myChar:GameChar<NewJob, Weapon, Armor> = {
    job: "무법자",
    weapon : "검",
    armor: "갑옷"
}
```

- 제네릭 파라미터에 특정 타입을 제한할 수 있다.