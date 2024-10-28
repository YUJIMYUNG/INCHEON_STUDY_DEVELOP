// 1. 엔화를 입력했을 때, 900보다 낮으면 "사야함!" 높으면 "팔아야함!" 함수 만들기
function exchange(e) {
  return e < 900 ? "사야함" : "팔아야함";
}

const result1 = exchange(1000);
console.log(`${result1}`);

// 2. 두 정수를 입력했을 때, 높은 값을 돌려주는 함수 만들기
function upAndDown(a, b) {
  return a > b ? a : b;
}

// 3. 커피 메뉴가 아메리카노, 라떼. 바닐라, 모카가 있다고 가정할 때
// 함수에 커피메뉴 번호와 갯수를 입력받고
// ~~커피와 ~~갯수 주문완료를 돌려주는 함수 만들기.
function orderList(num, count) {
  const coffeeList = {
    1: "아메리카노",
    2: "라떼",
    3: "바닐라",
    4: "모카",
  };
  return `${menu[num]} 커피와 ${count} 갯수 주문 완료!`;
}

const num_coffee = Number(prompt("커피 메뉴번호 입력"));
const count_coffee = Number(prompt("커피 갯수를 입력하세요"));

orderList(num_coffee, count_coffee);
