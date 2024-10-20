// 1. 유저에게 프로그래밍 점수를 입력 받고

// const score = Number(prompt("프로그래밍 점수를 입력하세요."));

// if (score >= 90) {
//   console.log("A");
// } else if (score >= 80) {
//   console.log("B");
// } else if (score >= 70) {
//   console.log("C");
// } else if (score >= 60) {
//   console.log("D");
// } else {
//   console.log("F");
// }

// // 2. 유저에게 각도(angle)을 물어보고, 평각, 직각, 둔각 예각 나타내기
// const angle = Number(prompt("각도를 입력하세요."));
// const isAcute = 0 < angle && angle < 90;
// const isRight = angle == 90;
// const isObtuse = 90 < angle && angle < 180;
// const isFalt = angle == 180 || angle == 0;
// if (isFalt) {
//   console.log("평각");
// } else if (isObtuse) {
//   console.log("둔각");
// } else if (isRight) {
//   console.log("직각");
// } else if (isAcute) {
//   console.log("예각");
// } else {
//   console.log("해당 각은 존재하지 않습니다.");
// }

// 버스 요금 계산기 프로그램
// 유저에게 1. 마을버스 2. 시내버스 3. 광역버스 4. 고속버스 를 선택하게하고
// 유저에게 나이를 물어보고, 어린이 50% 할인, 8~19살은 30% 할인, 65세 이상 : 20% 할인

// 모두 선택 . 후콘솔로그 : ~~ 버스의 최종 금액은 ~~ 입니다.

const bus = prompt(
  "1. 마을버스 2. 시내버스 3. 광역버스 4. 고속버스 중 숫자로 버스를 입력"
);
const userAge = prompt("나이를 숫자로 입력하세요.");

const bus1Price = 1000;
const bus2Price = 1200;
const bus3Price = 2500;
const bus4Price = 9000;

if (userAge <= 7) {
  if (bus == 1) {
    console.log(`${userAge}살의 버스 요금은 ${bus1Price * 0.5} 입니다.`);
  } else if (bus == 2) {
    console.log(`${userAge}살의 버스 요금은 ${bus2Price * 0.5} 입니다.`);
  } else if (bus == 3) {
    console.log(`${userAge}살의 버스 요금은 ${bus3Price * 0.5} 입니다.`);
  } else {
    console.log(`${userAge}살의 버스 요금은 ${bus4Price * 0.5} 입니다.`);
  }
} else if (userAge >= 8 && userAge < 20) {
  if (bus == 1) {
    console.log(`${userAge}살의 버스 요금은 ${bus1Price * 0.7} 입니다.`);
  } else if (bus == 2) {
    console.log(`${userAge}살의 버스 요금은 ${bus2Price * 0.7} 입니다.`);
  } else if (bus == 3) {
    console.log(`${userAge}살의 버스 요금은 ${bus3Price * 0.7} 입니다.`);
  } else {
    console.log(`${userAge}살의 버스 요금은 ${bus4Price * 0.7} 입니다.`);
  }
} else if (userAge >= 65) {
  if (bus == 1) {
    console.log(`${userAge}살의 버스 요금은 ${bus1Price * 0.8} 입니다.`);
  } else if (bus == 2) {
    console.log(`${userAge}살의 버스 요금은 ${bus2Price * 0.8} 입니다.`);
  } else if (bus == 3) {
    console.log(`${userAge}살의 버스 요금은 ${bus3Price * 0.8} 입니다.`);
  } else {
    console.log(`${userAge}살의 버스 요금은 ${bus4Price * 0.8} 입니다.`);
  }
} else {
  if (bus == 1) {
    console.log(`${userAge}살의 버스 요금은 ${bus1Price} 입니다.`);
  } else if (bus == 2) {
    console.log(`${userAge}살의 버스 요금은 ${bus2Price} 입니다.`);
  } else if (bus == 3) {
    console.log(`${userAge}살의 버스 요금은 ${bus3Price} 입니다.`);
  } else {
    console.log(`${userAge} 살의 버스 요금은 ${bus4Price} 입니다.`);
  }
}
