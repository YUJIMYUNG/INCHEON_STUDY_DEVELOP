// cgv 프롬프트 프롤그램

// 영화 : [보통의 가족, 베놈, 베테랑2, 와일드 로봇, ]

const movieList = [
  "보통의 가족",
  "베놈",
  "베테랑2",
  "와일드 로봇",
  "대도시의 사랑법",
]; // 가격 12000
const snackMenu = [
  { menu: "팝콘", price: 6000 },
  { menu: "카라멜팝콘", price: 6000 },
  { menu: "치즈팝콘", price: 6000 },
  { menu: "나초", price: 4000 },
  { menu: "오징어구이", price: 4000 },
];
const drinkMenu = [
  { menu: "콜라", price: 3000 },
  { menu: "제로콜라", price: 3000 },
  { menu: "스프라이트", price: 2000 },
  { menu: "제로스프라이트", price: 2000 },
];

const moviePrompt = prompt(
  "영화를 선택해주세요. 0. 보통의 가족, 1.베놈, 2. 베테랑2, 3.와일드 로봇, 4.대도시의 사랑법"
);
const snackPrompt = prompt(
  "스낵을 선택해주세요. 0.팝콘, 1.카라멜팝콘, 2.치즈팝콘, 3.나초, 4.오징어구이"
);
const drinkPrompt = prompt(
  "음료를 선택해주세요. 0.콜라, 1.제로콜라, 2.스프라이트, 3.제로스프라이트"
);

const selectedMovie = movieList[moviePrompt];
const selectedSnack = snackMenu[snackPrompt];
const selectedDrink = drinkMenu[drinkPrompt];

// 총 가격 계산
const totalPrice = 12000 + selectedSnack.price + selectedDrink.price;

console.log(
  `구매하신 제품" 영화 ${selectedMovie}, 스낵류${selectedSnack.menu}, 음료${selectedDrink.menu}`
);
console.log("총 가격 : " + totalPrice + "원 입니다.");
