// 두 정수를 유저에게 입력 받고, 더 큰 숫자를 알럿으로 나타내기 :
// const num1 = Number(prompt("첫번째 정수를 입력하세요"));
// const num2 = Number(prompt("두번째 정수를 입력하세요"));

// alert(a > b ? a : b);

// 1. 도너츠 구매 갯수를 입력, 도너츠 가격 입력
// 10개 이상이면 10% 할인, 20개 이상이면 20%할인
const donutCount = prompt("도너츠 구매 갯수를 입력하세요.");
const donutPrice = prompt("도넛의 가격을 입력하세요.");
const totalPrice = donutCount * donutPrice;

const isUnder10 = donutCount < 10;
const isOver10andUnder20 = 10 <= donutCount && donutCount < 20;
const isOver20 = 20 <= donutCount;

isUnder10 && alert(`총 금액:${totalPrice}`);
isOver10andUnder20 && alert(`총 금액:${totalPrice * 0.9}`);
isOver20 && alert(`총 금액:${totalPrice * 0.8}`);

// 2. 정수를 입력해서 홀수인지 짝수인지 알려주기
// 정수를 입력하면 콘솔로그 ~~ 홀수 / 짝수 입니다.
const num = prompt("정수를 입력하세요.");
const result = num % 2 ? "홀수" : "짝수";
console.log(`정수 ${num}은(는) ${result}입니다.`);
