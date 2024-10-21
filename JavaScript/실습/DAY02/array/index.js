// 참조타입 : Object, Array

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
  { name: "아메리카노", price: 1500 },
  { name: "라떼", price: 2500 },
  { name: "민트모가", price: 4500 },
];

console.log(menu[1]["name"]);
