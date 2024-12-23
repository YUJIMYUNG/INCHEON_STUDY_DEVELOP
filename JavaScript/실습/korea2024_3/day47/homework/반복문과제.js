/*
[문제4] 로또 번호 입력 프로그램 .
- 조건1 : 배열내 중복 값 은 없어야 한다.
- 조건2 : 1 부터 45 사이의 값만 입력받는다. 
- 조건3 : 총 6개의 번호만 입력받는다.
- 입력조건 : prompt()함수 출력 
- 출력조건 : 특정 div에 입력받은 로또 번호 6개를 출력하기.

*/
let lottoNum = [];
let lottoHTML = ``;

while(lottoNum.length < 6){
    let inputNumber = Number(prompt("1~45 사이의 로또 번호를 입력하세요."));

    if(lottoNum.includes(inputNumber)){
        alert('이미 입력된 번호입니다.');
        continue;
    }
    if(inputNumber < 1 || inputNumber > 45){
        alert('1~45 사이의 숫자만 입력하세요.');
        continue;
    }
    lottoNum.push(inputNumber);
}

for(let i = 0; i < lottoNum.length; i++){
    lottoHTML += `${lottoNum[i]} `;
}
// (3) 특정한 선택자의 마크업을 JS객체로 가져오기 
let exampleDIV4 = document.querySelector('#exampleDIV4');
exampleDIV4.innerHTML = lottoHTML;

console.log(lottoNum);
console.log(lottoHTML);