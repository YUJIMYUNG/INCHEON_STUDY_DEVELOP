//1. 유저에게 운동 3개를 물어보고, 콘솔로 1번운동 2번운동 3번운동 을 나타내도록 만들어주세요
const exercise1 = prompt("첫번째 운동 종목을 입력해주세요");
const exercise2 = prompt("두번째 운동 종목을 입력해주세요");
const exercise3 = prompt("세번째 운동 종목을 입력해주세요");
console.log(`운동1 : ${exercise1}, 운동1 : ${exercise2}, 운동1 : ${exercise3}`);

//2. 두 정수를 m, n 입력받고, m의 n제고븽 결과를 콘솔로 나타내기
const m = prompt("첫번쨰 정수를 입력하세요.");
const n = prompt("두번쨰 정수를 입력하세요.");
console.log(`첫번째 정수의 두번째 제곱의 값은 : ${Number(m) ** Number(n)}`);

//3. 달러 입력하면 원화로 콜솔로 나타내기
const dollor = prompt("원화로 입력하면 달러로 계산");
console.log(`${Number(dollor) * 1369}`);

//4. 1000 이하의 정수를 입력 받고, 분초로 나타내기!
// 65-> 1분 5초, 192 -> 3분 12초
const time = prompt(
  "1000 이하의 정수를 입력하면 분, 초로 계산합니다. ex) 65-> 1분 5초"
);
const minute = Number(time) / 60;
const second = Number(time) % 60;
console.log(`${time}초는 ${parseInt(minute)}분 ${second}초 입니다. `);
