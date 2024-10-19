// 1. 유저에게 첫 번째 숫자, 두 번째 숫자를 입력 받고
// 두 수의 합을 콘솔 로그로 나타내기

const num1 = prompt("첫번째 숫자를 입력하세요.");
const num2 = prompt("두번째 숫자를 입력하세요");
const result = Number(num1) + Number(num2);

console.log(`두 수의 합은 ${result} 입니다.`);

// 2. 유저에게 나이를 물어보고, 태어난 년도 콘솔로그 나타애기
const age = prompt("나이가 어떻게 되나요?");
const born = (Number(age) - 2024) * -1;
console.log(`${born}년생 입니다.`);

// 3. 유저에게 한 변의 길이를 입력받고 정사각형의 넓이 나타내기
const squareLength = prompt("정사각형 한 변의 길이를 입력하세요.");
console.log(`정사각형의 넓이는 ${Number(squareLength * squareLength)} 입니다.`);

// 4. 유저에게 밑변과 높이를 입력 받고, 정삼각형의 넓이 나타내기
const triangleBottom = prompt("정삼각형 밑변의 길이를 입력하세요.");
const triangleHeight = prompt("정삼각형 높이의 길이를 입력하세요.");

console.log(
  `정삼각형의 넓이는 ${Number(triangleBottom * triangleHeight)} 입니다.`
);

// 5. 유저에게 반지름을 입력 받고, 원이 넓이와 둘레 나타내기
const radius = prompt("반지름의 길이를 입력해주세요");
console.log(
  `원의 둘레는 ${Number(radius * 2)} 이고 원의 넓이는 ${Number(
    radius * radius * 3.14
  )}입니다.`
);

// 6. 유저에게 일본 여행 . 갈여비를 엔화로 바꾸기

const changedJpy = prompt("일본 여행 여비를 얼마 환전할건가요?");
console.log(`${Number(changedJpy * 0.916)} 엔이요.`);
