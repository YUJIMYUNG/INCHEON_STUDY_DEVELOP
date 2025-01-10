//피자 주문 타입
//아이티 피자 세트
//메인피자[마르게리따, 곤졸라, 불고기, 하아이완, 콤비네이션], 
//토핑종류[버섯, 피망, 크러스트, 고기, 양파],
//음료[콜라, 환타, 사이다, 맥주]

type Main = "마르게리따" | "곤졸라" | "불고기" | "하와이안" | "콤비네이션";
type Topping = "버섯" | "피망" | "크러스트" | "고기" | "양파";
type Drink = "콜라" | "환타" | "사이다" | "맥주";

type PizzaSet = {
    main:Main, topping:Topping[] , drink:Drink[]
}

const pizzaOrder = (pizza:PizzaSet) => {
    console.log(`주문하신 피자 : ${pizza.main} 토핑종류: ${pizza.topping} 음료종류: ${pizza.drink}` )
}

// 노트북 설정타입
// brand: 애플, hp, 레노버, 아서스, 삼성, 엘지
// cpu : i5, i7, m2, m3
// ram : 8gb, 16gb, 32gb, 64gb
// storage : ssd-256, ssd-512, ssd-1024, hdd-256
// 마이노트북으로 노트북 설정타입을 갖는 변수 선언하기
type Brand = "애플" | "hp" | "레노버" | "아서스" | "삼성" | "엘지";
type Cpu = "i5" | "i7" | "m2"| "m3";
type Ram = "8gb" | "16gb" | "32gb" | "64gb";
type Storages = "ssd-256" | "ssd-512" | "ssd-1024" |" hdd-256";

type Com = {brand : Brand} & {cpu : Cpu} & {ram :Ram} & {storage: Storages}

const myCom: Com = {
    brand:"hp",
    cpu:"i5",
    ram: "16gb",
    storage: " hdd-256"
}