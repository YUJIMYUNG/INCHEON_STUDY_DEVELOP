// 일반함수, 화살표 함수, 콜백함수
// 콜백함수 : 마술상자 안에 마술상자를 넣기

const recipe = (food) => {
  console.log("요리 시작!!!");
  food();
  console.log("요리 끝!!");
};

const kimchiStew = () => {
  console.log("김치 썰기");
  console.log("물 끓이기");
  console.log("김치 넣기");
  console.log("김치찌개 완성");
};
const kimchiRice = () => {
  console.log("김치 썰기");
  console.log("프라이팬 달구기");
  console.log("김치랑 . 밥넣기");
  console.log("볶기");
  console.log("김치볶음밥 완성");
};

recipe(kimchiRice);
