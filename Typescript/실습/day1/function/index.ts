const add = (x:number, y:number): number => {
    return x + y;
};

// 곱하기 함수
const multi = (x:number, y:number): number => {
    return x * y;
}

//어떤 숫자를 입력해서 홀수면 콜라 짝수면 사이다가 나오는 함수
const test1= (num:number):string => {
    return num % 2 ? "사이다" : "콜라";
}

//어떤 문자가 들어가서 빈문자면 false, 아니면 true가 나오는 함수
const test2 = (str:string):boolean => {
    return !!str;
}

const printMsg = (str:string): void => {
    console.log(`${str} 출력!`) //return(반환값) 없으면 void
}

const callName = (first:string, last?:string) => {
    console.log(`${first}성 ${last}이름`);
};
const callName1 = (first:string, last:string= "Guest") => {
    console.log(`${first}성 ${last}이름`);
};

callName("김");
callName("이","순신");

// 어떤 문자와 숫자를 넣으면 그 문자가 숫자만큼 곱해져서 나오는 함수
const multi2 = (x:string, y:number): string => {
   return x;
}