type Pair<T, U> = {
    first:T,
    second:U
}

const test6:Pair<string, boolean> = {
    first:"김떙떙",
    second:false
}

// 맨도날드 세트 제너릭 사용해서 정의
// main, sub, drink 
// 변수 만들기
type macMain = "상하이" | "치즈버거" |"빅맥";
type Macdonald<T, U, V> = {
    main: T,
    sub: U,
    drink: V
}
const myMacdonaldMenu:Macdonald<macMain, string, string> = {
    main: "치즈버거",
    sub : "감튀",
    drink: "오렌지쥬스"
}

//피자 타입 cheese, topping, crust 포함유무 타입 제너릭으로 설정
type Cheese = "노란치즈" | "하얀치즈";
type Topping = "양파" | "고기" | "올리브" | "페퍼로니";
type PizzaMenu<T, U> = {
    cheese: Cheese,
    topping : Topping[],
    crust : boolean
}
const myPizza:PizzaMenu<Cheese, Topping> = {
    cheese: "노란치즈",
    topping: ["고기", "양파"],
    crust: true
}