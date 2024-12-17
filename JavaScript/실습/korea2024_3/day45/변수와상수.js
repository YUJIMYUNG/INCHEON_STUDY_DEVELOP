//실습1 : prompt() 함수로 하나의 점수를 입력받아서 console.log()함수로 console 탭에 입력받은 점수를 출력하시오

const num = prompt("하나의 점수를 입력하세요.");
console.log(num);


//실습2 
// prompt() 함수로 국어점수와 수학점수를 각각 입력받아서
//console.log()함수에 총점과 평균을 출력하시오.

const korPoint =  Number(prompt("국어 점수를 입력하세요."));
const mathPoint = Number(prompt("수학 점수를 입력하세요."));

console.log(`총점은 ${korPoint + mathPoint} 이고 평균은 ${(korPoint + mathPoint) / 2}입니다.`)