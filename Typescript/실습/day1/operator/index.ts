//유니언 연선자 (|)
const nickname:string | number = "123" // 문자형 또는 숫자형 들어올 수 있음

//문자 or문자배열
const quiz:string | string[] = "문제1";

//오브젝트 or 불리언
const quiz2:{} | boolean = true;

//비행기 오브젝트 {항공사이름, 비행기모델:문자or숫자, 승객수}
const airplane:{name : string, model: string | number, person: number} = {name : "대한" , model:890, person: 200};

//인터섹션 연산자(&)

//never : 그런 타입 없다(간접적 에러 경고)
//const test4: number & string

const university_student: {name:string} & {major:string} = {
    name:"홍길동",
    major:"아무학과",
};

//cookie 이름, 칼로리 숫자or 문자, 가격
const cookie: {name:string} & {kcal:number | string} & {price:number} = {
    name : "초콜릿쿠키",
    kcal : "350",
    price: 3500,
}