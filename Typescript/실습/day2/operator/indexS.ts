//indexS

type StudentMathScore = { [name:string]:number};

const classOne:StudentMathScore = {
    kim: 50,
    lee: 50,
    park: 60
}

//영어점수
type EngScore = {[name:string]:number};
const classTwo:EngScore = {
    kim : 100,
    lee: 10,
    park : 40
}

//국어점수, 등급도 갖는 배열 형태의 오브젝트로 만들기
type Grade = "A" | "B" | "C" | "D" | "F"; 
//타입 안정성을 위해서 부분집합의 개념으로 넣기
type KorScore = {[name:string]:number | Grade} & {grade:Grade};
const classTree:KorScore[] = [
    { kim :30, grade:"F"},
    { lee :100, grade:"A"},
    { park :80, grade:"B"},
]

// Dictionary 타입을 만들고
type Dictionary = { [key:string]: string};
const eng:Dictionary = {
    apple:"사과",
    orange:"오렌지"
}