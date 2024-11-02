const menu = [
  { name: "americano", price: 2500, shots: 2, ingridients: ["water", "bean"] },
  { name: "latte", price: 3500, shots: 3, ingridients: ["milk", "bean"] },
  {
    name: "mocha",
    price: 4000,
    shots: 3,
    ingridients: ["milk", "bean", "choco", "syrup"],
  },
];

// 가격 10퍼 할인
const newMenu = menu.map((x) => {
  x.price = x.price * 0.9;
  return x;
});
console.log(newMenu);

// 이름 모두 대문자화
const newMenu2 = menu.map((x) => {
  x.name = x.name.toUpperCase();
  return x;
});
console.log(newMenu2);

// 우유가 포함되어 있으면 가격 1000원 인상
const newMenu3 = menu.map((x) => {
  x.price = x.ingridients.includes("milk") ? x.price + 1000 : x.price;
  return x;
});
console.log(newMenu3);

// 샷의 갯수가 2개보다 많으면 메뉴에서 제외하고 성분에 "strawberry 추가"
const newMenu4 = menu
  .filter((x) => x.shots <= 2)
  .map((x) => {
    x.ingridients.push("strawberry");
    return x;
  });
console.log(newMenu4);
