type Container<T> = {
    value: T;
}

const test:Container<string> = {
    value:"장난감",
}

const test1: Container<boolean> = {
    value:false,
}

//과일 컨테이너 타입을 정의
//과일 타입 사과, 바나나, 파인애플, 망고
type Fruit = "사과" | "바나나" | "파인애플" | "망고";
const fruitContainer: Container<Fruit> = {
    value: "사과"
}
//자동차 컨테이너 타입을 정의
//자동차 타입 페라리, 람보르기니, 테슬라, 현대
type Car = "페라리" | "람보르기니" | "테슬라" | "현대";
const carContainer:Container<Car> = {
    value: "람보르기니"
} 