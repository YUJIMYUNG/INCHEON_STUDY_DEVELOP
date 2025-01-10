//리터럴 타입
type Course = "리액트" | "자바" | "파이썬" | "C언어" ;
const Eclass: Course = "리액트";

type StatusCode = 200 | 404 | 500;

const getData = (code:StatusCode) => {
    if(code == 200) console.log("통과");
    else if(code == 404) console.log("클라이언트 에러");
    else if(code == 500) console.log("서버 에러");
    else console.log("특수 에러");
}

//맥도날드 세트타입
//메인메뉴 : 빅맥, 치즈, 새우, 불고기, 상하이
//서브메노 : 감튀, 코우슬로, 치즈스틱
//음료메뉴 : 콜라, 제로콜라...

type MainMenu = "빅맥" | "치즈" | "새우" | "불고기" | "상하이";
type SubMenu = "감튀" | "코우슬로" | "치즈스틱" | "양파튀김";
type DrinkMenu = "콜라" | "제로콜라" | "사이다" | "스프라이드" | "쥬스";
type Macdonald = {
    main: MainMenu,  sub:SubMenu, drink:DrinkMenu};
type MaksSet = (main: MainMenu,  sub:SubMenu, drink:DrinkMenu) => Macdonald;

const order: MaksSet = (main, sub, drink) => {
    return {main, sub, drink};
}

const myOrder = order("빅맥","양파튀김", "스프라이드");

//서브웨이
type Bread = "허니오트" | "하티" | "화이트" | "파마산 오레가노";
type Cheese = "아메리칸치즈" | "슈레드치즈";
type Veggies = "양상추" | "토마토" | "양파" | "올리브" | "할라피뇨";
type Subway = {
    bread : Bread, cheese :Cheese, veg:Veggies[]
};
const subOrder= (bread : Bread, cheese :Cheese, veg:Veggies[]) => {
    return {bread, cheese, veg};
}

const mySuvOrder = subOrder("파마산 오레가노","슈레드치즈",["양파", "양상추", "토마토", "올리브"]);