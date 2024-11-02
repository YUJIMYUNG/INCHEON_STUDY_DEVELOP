// filter 걸러줘!
const arr = [1, 2, 3, 4, 5];

const test = arr.filter((x) => x == 1 || x == 3);

const test1 = arr.filter((x) => x % 2 == 0);

console.log(test);
console.log(test1);

// 1. 30 이하만 살리기
const arr1 = [10, 20, 30, 40, 50];
const test2 = arr1.filter((x) => x <= 30);
console.log(test2);

// 2. 글자 길이가 5글자 이하만 살리기
// 3. 알파벳 i 또는 e가 포함한 과일만 살리기!
const fruits = ["apple", "banana", "kiwi", "mango", "watermelon"];
const test3 = fruits.filter((x) => x.length <= 5);
console.log(test3);

const test4 = fruits.filter((x) => x.includes("e") || x.includes("i"));
console.log(test4);

// fruits에서 alphabet에 들어간 요소가 있는것만 필터링
const alphabet = ["k", "j", "q", "r"];
const test5 = fruits.filter((x) => alphabet.some((y) => x.includes(y)));
console.log(test5);

// 기본 : string, number, boolean
// 참조 : array, object, student("이름", 24, 전공여부)
const k = Number("10");
const j = Number("10");

// const a = new student("전수효", 24, 전공여부);
// const b = new student("전수효", 24, 전공여부); // a와 b는 다르다

// 메소드 체이닝
const c = new Array(20).fill("김밥");
const c1 = new Array(10).fill(1);
const c2 = new Array(10).fill(0).map((x) => x + 1);

// 0 ~ 999 배열
const arr3 = new Array(1000).fill(0).map((x, i) => i);

// 1. 0~1000 배열이 있고 홀수만 담기!
const arr4 = new Array(1000)
  .fill(0)
  .map((x, i) => i)
  .filter((x) => x % 2 == 1);
console.log(arr4);
// 2. 0~1000 배열이 있고 3의 배수만 담기!
const arr5 = new Array(1000)
  .fill(0)
  .map((x, i) => i)
  .filter((x) => x % 3 == 0);
console.log(arr5);
// 3. 0~1000 배열이 있고 5의 배수만 담고, 500~600은 거르기!
const arr6 = new Array(1000)
  .fill(0)
  .map((x, i) => i)
  .filter((x) => x % 5 == 0)
  .filter((x) => x < 500 || 600 < x);
console.log(arr6);

// map, filter, reduce(누적시켜줘)

//reduce((a, c)=>{})
[1, 3, 5, 7, 9].reduce((a, c) => {
  console.log({ a, c });
  return a + c;
});

// 1부터 123의 누적의 합 구하기
const arr7 = new Array(123)
  .fill(0)
  .map((x, i) => i + 1)
  .reduce((a, c) => a + c);
console.log(arr7);
