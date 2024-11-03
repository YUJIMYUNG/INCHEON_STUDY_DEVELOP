# Object & Array

<aside>
💡

**Object 타입은 `키(key)와 값(value)`의 쌍으로 구성된 복합 데이터 타입이다.**

**Array 타입은 중괄호[]를 사용해서 데이터를 순서대로 담는 복합 데이터 타입이다.**

</aside>

## Grammer

---

### Object

```jsx
const coffee = new Object();

const car = {
    color : "white",
    maxSpeed : 300,
    company : "kia",
    model : "쏘렌토",
};

car.color // dot 접근법
car["color"] // bracket 접근법
car.owner = "엄준식" //데이터 추가
delete car.company // kia 데이터 삭제

const calc = {
  add: function (a, b) {
    return a + b;
  },
  substract: function (a, b) {
    return a - b;
  },
};
```

- Key는 String or 정수만 가능
- Value는 Any 타입

### Array

```jsx
const students = new Array(10);

const soccer = ["손흥민", "김민재", "황희찬", "이강인"];

console.log(soccer[0]); // 손흥민, 0 이 첫번째임
console.log(soccer[3]); // 이강인

const lotto = [3, 8, 12, 25, 30, 39];

const score = [
  [1, 2, 3],
  [10, 11, 12],
  [54, 55, 56],
];

console.log(score[2][0]); //54
console.log(score[1][2]); //12

const menu = [
    { name : "아메리카노", price: 1500},
    { name : "라떼", price: 2500},
    { name : "민트모가", price: 4500},
]

console.log(menu[1]["name"]);
```

- Array의 시작 번호는 0번째