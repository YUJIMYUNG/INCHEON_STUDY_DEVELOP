// 1. prompt로 유저에게 정수를 입력받고, 양수 or 0 or 음수를 알려주는 프로그램 만들기
const num = Number(prompt("정수를 입력해주세요."));

if (num == 0) {
  console.log(`입력한 ${num}은 0 입니다.`);
} else if (num < 0) {
  console.log(`입력한 ${num}은 음수 입니다.`);
} else {
  console.log(`입력한 ${num}은 양수 입니다.`);
}

// 2. prompt로 키와 몸무게를 입력받고, bmi지수에 따라서 결과 나타낸기
// ex) 173 85 -> 비만
const weight = Number(prompt("몸무게를 입력하세요."));
const height = Number(prompt("키를 입력하세요.")) * 0.01;
const bmi = (weight / height) * height;

if (bmi < 18.5) {
  console.log("저체중입니다.");
} else if (bmi >= 18.5 && bmi <= 22.9) {
  console.log("정상 체중입니다..");
} else if (bmi >= 23 && bmi <= 24.9) {
  console.log("비만 전단계입니다..");
} else {
  console.log("비만입니다..");
}

// 3. prompt로 유저에게 태어난 년도를 입력받고, 띠 나타내기
// 2000 -> 용띠, 2005 -> 닭띠
const born = Number(prompt("태어난 연도를 입력하세요."));
const animalYear = born % 12;
// if (animalYear == 0) {
//   console.log(`${born} 년생은 원숭이띠입니다.`);
// } else if (animalYear == 1) {
//   console.log(`${born} 년생은 닭띠입니다.`);
// } else if (animalYear == 2) {
//   console.log(`${born} 년생은 개띠입니다.`);
// } else if (animalYear == 3) {
//   console.log(`${born} 년생은 돼지띠입니다.`);
// } else if (animalYear == 4) {
//   console.log(`${born} 년생은 쥐띠입니다.`);
// } else if (animalYear == 5) {
//   console.log(`${born} 년생은 소띠입니다.`);
// } else if (animalYear == 6) {
//   console.log(`${born} 년생은 호랑이띠입니다.`);
// } else if (animalYear == 7) {
//   console.log(`${born} 년생은 토끼띠입니다.`);
// } else if (animalYear == 8) {
//   console.log(`${born} 년생은 용띠입니다.`);
// } else if (animalYear == 9) {
//   console.log(`${born} 년생은 뱀띠입니다.`);
// } else if (animalYear == 10) {
//   console.log(`${born} 년생은 말띠입니다.`);
// } else if (animalYear == 11) {
//   console.log(`${born} 년생은 양띠입니다.`);
// }

const animal = {
  0: "원숭이",
  1: "닭",
  2: "개",
  3: "돼지",
  4: "쥐",
  5: "소",
  6: "호랑이",
  7: "토끼",
  8: "용",
  9: "뱀",
  10: "말",
  11: "양",
};
console.log(animal[animalYear]);
