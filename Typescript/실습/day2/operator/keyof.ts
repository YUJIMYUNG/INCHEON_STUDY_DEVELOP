type Person = {name:string, age:number};
type Test = keyof Person;
const test:Test = "name";

// 커피타입 이름, 샷 수 , 성분
// 키오브를 사용해서 test1에서 샷 수를 변수로 담는 코드
type Coffee = {name:string, shot:number, ingredents:string[]};
type Test1 = keyof Coffee;
const test1:Test1 = "shot";

type Student = {name:string, age:number};
type StudentKey = keyof Student;

const getStudentProperty = (student:Student, key:StudentKey) => {
    return student[key];
};

const kim:Student = {name:"김민재" , age :28};
getStudentProperty(kim, "age")// 28

//퀴즈
//Colors 타입을 만들고 primary, secondary, success, danger
//키오브로 키 값들을 추출하고
//만약에 키값들로 이름을 주었을 때, 해당 색상들을 돌려주는 함수를 만들면 됨
//ex)getColor("primary") => green
type Color = {primary:string, secondary:string, success:string, danger:string };
const basicColor:Color = {primary: "green", secondary:"deepgreen" , success: "white", danger:"red" };
type ColorKey = keyof Color;
const getColor = (colorkey:ColorKey) => {
    return basicColor[colorkey];
}

getColor("primary");

//퀴즈2
//backgroudColor => first: second: deactive: hover:
//getBgColor => 원하는 헥사코드 나오도록 설정
type BackgroundColor = {first:string, second:string, deactive:string, hover:string };
const backgroudColor:BackgroundColor = {
    first:"#FED2E1",
    second: "#E2DDFE",
    deactive:"#FFE629",
    hover: "#FFE0C2"
}
type BgColorKey = keyof BackgroundColor;
const getBgColor = (bgcokorKey:BgColorKey) => {
    return backgroudColor[bgcokorKey];
}

getBgColor("hover");