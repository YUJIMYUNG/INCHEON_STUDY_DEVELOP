//문자타입 만들기
const movie:string = "10";

//숫자타입
//불리언타입 만들기
const num:number = 8;
const yesOrNo:boolean = true;

//배열타입
const coffees: string[] = ["아메리카노", "라떼"];
const coffees1: Array<string> = ["디카페인", "고구마라떼"];

//숫자배열타입
const numList: number[] = [1, 2, 3];
//불리언배열타입
const booleanList: Array<boolean> = [true, false, false];


//오브젝트
const student: {name:string, age:number} = {
    name: "유지명",
    age : 23,
};

//latte 오브젝트 shots, kcal, ingredients
const latte: {shots:number, kcal:number, ingredidnts:string} = {
    shots: 2,
    kcal: 500,
    ingredidnts: "우유"
}

//car 오브젝트 배열
//name, model, engine{name,model,power}
const car:{
    name:string,
    model:string, 
    engine: {name:string, model:string, power:number}}[] = [
        {name:"테슬라", model:"y", engine:{name:"abc", model:"k1", power:100}},
        {name:"테슬라2", model:"x", engine:{name:"abc", model:"k1", power:100}},
    ];

//도너츠 오브젝트 배열
//이름, 칼로리, 성분, 오브젝트배열 {name, 함량}
const donuts:{name:string, kcal:number, ingredient:{name:string, content:number}[]}[] =[
    {name:"초코도넛", kcal:400, ingredient:[{name:"설탕", content:50}, {name:"초콜릿", content:20}]},
    {name:"딸기도넛", kcal:400, ingredient:[{name:"설탕", content:50}, {name:"딸기", content:20}]},
];