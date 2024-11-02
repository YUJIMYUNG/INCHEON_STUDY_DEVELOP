// 카페 포스기 프로그램

// 카페에 기본메뉴 : ["아아", "라뗴"];
// 가격: [2500, 3000];
const cafe = {
  menu: [
    { name: "아메리카노", price: 2500 },
    { name: "라떼", price: 3000 },
  ],
  cost: function (name, price, amount) {
    return price * amount;
  },
  info: function () {
    console.log(this.menu);
  },
  addMenu: function () {
    const name1 = prompt("메뉴 이름 입력");
    const price1 = Number(prompt("메뉴 가격 입력"));
    this.menu.push({ name: name1, price: price1 });
  },
  // 메뉴 삭제 만들기
  // 유저에게 커피 이름을 입력 받으면 해당 메뉴 삭제하기
  delMenu: function () {
    const delname = prompt("삭제할 커피 이름");
    this.menu.filter((x) => x.name != delname);
  },
};

cafe.addMenu();
cafe.addMenu();
cafe.info();

// 정산 프로그램
// 커피이름, 가격, 갯수 입력 받으면 총 가격을 돌려주는 함수
