// 일반함수, 화살표 함수
const car = {
  name: "캐스퍼",
  speed: 0,
  color: "white",
  start: function () {
    console.log("부릉부릉");
  },
  end: function () {
    console.log("시동 끔");
  },
};

car.start();
car.end();

const calc = {
  add: function (a, b) {
    return a + b;
  },
  substract: function (a, b) {
    return a - b;
  },
};
