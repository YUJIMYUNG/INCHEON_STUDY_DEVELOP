/*
    JS과제1 : 연산자 10개 풀이하기.
        - 입력조건 : prompt()
        - 출력조건 : console.log()
        - 일반조건 : if조건문 과 for반복문 사용금지 , chatGPT 사용금지
        [지문1] prompt 함수로 국어 , 영어 , 수학 점수를 각 입력받아서 각 변수에 저장하고 총점 과 평균을 계산하여 console탭에 출력하시오.
        [지문2] prompt 함수로 반지름를 입력받아서 원넓이[반지름*반지름*3.14] 계산하여 console탭에 출력하시오.
        [지문3] prompt 함수로 두 실수를 입력받아서 앞 실수의 값이 뒤실수의 값의 비율% 계산하여 console탭에 출력하시오. 예) 54.5  84.3 입력시 결과는 64%
        [지문4] prompt 함수로 정수를 입력받아 입력받은 값이 홀수이면 true / 짝수이면 false 로 console탭에 출력하시오.
        [지문5] prompt 함수로 정수를 입력받아 입력받은 값이 7의 배수이면 true / 아니면 false 로 console탭에 출력하시오.
        [지문6] prompt 함수로 아이디 와 비밀번호를 입력받아서 아이디가 'admin' 이고 비밀번호가 1234 와 일치하면 true / 아니면 false 를 console탭에 출력하시오.
        [지문7] prompt 함수로 정수를 입력받아 입력받은 값이 홀수 이면서 7배수 이면 true / 아니면 false 로 console탭에 출력하시오.
        [지문8] prompt 함수로 십만원 단위의 금액을 입력받아 입력받은 금액의 지폐수를 console탭에 출력하시오.
            -> 입력 예] 356789 입력시 , 출력 예] 십만원:3장 만원:5장 천원6장 
        [지문9] 1차점수 와 2차점수 prompt함수로 각 입력받아서 총점이 150점이상이면 '합격' 아니면 '불합격' 를 console탭에 출력하시오.
        [지문10] 두 사람의 이름을 prompt함수로 각 입력받아서 
            -> 만일 이름이 '유재석' 이면 뒤에 (방장) 이라고 이름 뒤에 붙이고 아니면 생략 하여  console탭에 출력하시오. ex] 유재석(방장) , 강호동 

    - 정답이 필요한 경우 메일/카톡 로 요청하기. 
    - 제출 : itdanja@kakao.com , 12/18(수) 19:00까지
    - 제출파일 : 구현한 JS 파일 및 파일이 위치한 본인 github 상세 주소
*/

//지문1
let korPoint = Number(prompt("국어 점수를 입력하세요."));
let engPoint = Number(prompt("영어 점수를 입력하세요."));
let mathPoint = Number(prompt("수학 점수를 입력하세요."));

let totalPoint = korPoint + engPoint + mathPoint ;
let avgPoint = totalPoint / 3;

console.log(`국어, 영어, 수학 점수의 총점은 ${totalPoint} 이고, 평균 점수는 ${avgPoint} 입니다.` );

//지문2
let radius = Number(prompt("반지름의 길이를 입력하세요."));
let area = radius * radius * 3.14;
console.log(area);

//지문3
let val1 = Number(prompt("첫번째 실수를 입력하세요."));
let val2 = Number(prompt("두번째 실수를 입력하세요."));
let ratio = parseInt((val1 / val2) * 100);
console.log(ratio + "%");

//지문4
let val3 = Number(prompt("정수를 입력하세요. (홀수/짝수 구분)"));
console.log(val3 % 2 ? "홀수" : "짝수");

//지문5
let val4 =  Number(prompt("정수를 입력하세요. (7의 배수 구분)"));
console.log(val4 % 7 == 0 ? "7의 배수입니다(true)." : "7의 배수가 아닙니다(false).");

//지문6
let id = prompt("아이디를 입력하세요.");
let password = Number(prompt("비밀번호를 입력하세요."));
console.log(id == "admin" && password == 1234 ? "true" : "false" );

//지문7
let val5 = Number(prompt("정수를 입력하세요. (홀수이면서 7의 배수 구분)"));
console.log(((val5 % 2 == 1) && (val5 % 7 == 0))? "true" : "false");

//지문8
let money = Number(prompt("십만원 단위의 금액을 입력하세요."));
let oneHunderedThousand = parseInt(money / 100000) ;
let tenThousand = parseInt((money - (oneHunderedThousand * 100000)) / 10000);
let ontThousand = parseInt((money - (oneHunderedThousand * 100000) - (tenThousand * 10000)) / 1000);
console.log(`십만원 : ${oneHunderedThousand}장, 만원 : ${tenThousand}장, 천원 : ${ontThousand}장`);

//지문9
let firstPoint = Number(prompt("1차 점수를 입력하세요."));
let secondPoint = Number(prompt("2차 점수를 입력하세요."));
console.log(firstPoint + secondPoint >= 150 ? "합격" : "불합격");

//지문 10
let name1 = prompt("첫번째 사람의 이름을 입력하세요.");
let name2 = prompt("두번째 사람의 이름을 입력하세요.");
console.log(name1 === "유재석" ? name1+"(방장)," + name2 : name2 === "유재석" ? name1 + "," + name2 + "(방장)" : name1 +"," + name2);