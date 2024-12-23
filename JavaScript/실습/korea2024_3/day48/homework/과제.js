// <!--
//     JS과제4 (day48) : 함수 활용.
//     - 출력조건 : document.querySelector().innerHTML 
//     - 입력조건 : document.querySelector().value
//     - 일반조건 : chatGPT 사용금지

//     주제 : 미니 웹페이지 가계부
//         1. 가계부 정보(항목) : 1. 날짜 2.항목명 3.금액 
//         2. 세가지의 정보를 <input> 마크업으로 부터 입력 받아 각각 하나의 배열 저장 하시오.
//         3. 등록된 모든 배열 정보들을 출력 하시오.
//         3. HTML 출력 예시 
//         날짜            항목        금액
//         2024-11-26      콜라        1000
//         2024-11-27      커피        1200

//     - 정답이 필요한 경우 메일/카톡 로 요청하기. 
//     - 제출 : itdanja@kakao.com , 12/23(월) 19:00까지
//     - 제출파일 : 구현한 JS 파일 및 파일이 위치한 본인 github 상세 주소
// -->

let date = []; // 등록한 날짜 저정하는 배열
let itemNames = []; // 등록한 항목이름 저장하는 배열
let price = []; // 등록한 금액 저장하는 배열 

function register(){

    let dateValue = document.querySelector('.date');
    let nameValue = document.querySelector('.name');
    let priceValue = document.querySelector('.price');


    date.push(dateValue.value);
    itemNames.push(nameValue.value);
    price.push(priceValue.value);

    print();


    console.log(date);
    console.log(itemNames);
    console.log(price);
}

function print() {
    let arrayBox = document.querySelector('.arrayBox')

    // table start
    let outHtml = `<table border=1> <tr> <th> 날짜 </th> <th> 항목명 </th> <th> 금액 </th> </tr>`;
    for(let i = 0; i < date.length; i++){
        outHtml += `<tr><td> ${date[i]}</td>
            <td> ${itemNames[i]}</td> 
            <td> ${price[i]}</td></tr>`
    }// for end
    outHtml += `</table>` //table end
    
    arrayBox.innerHTML = outHtml;
    
}
