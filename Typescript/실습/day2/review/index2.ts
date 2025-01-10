// 타입스크립트 시작학
//1. npm install -g typescript 설치
//2. npx tsc --init 이 폴더에 타입스크립트 시작
//3. tsc ~~.ts 타입스크립트를 자바스크립트로 바꾸기 작업

//어노테이션
const myCoffee:string = "";
const menu: string[] = ["아메리카노", "라떼", "카페모카"];
const add = (x:number, y:number):number => x + y;

type  Android = {version:number, fucntion:string[]};
const andfoid14:Android = {
    version : 14,
    fucntion: ["지문인식", "얼굴인식"]
}

type Gender = "남성" | "여성";
