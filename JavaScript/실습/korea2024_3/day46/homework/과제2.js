// JS과제2 (day46) : 조건문 10개 풀이하기.
// - 입력조건 : prompt() 함수 사용.
// - 출력조건 : console.log() 함수 사용.
// - 일반조건 : for반복문 사용금지 , chatGPT 사용금지

// [지문1] 3개의 점수를 각 입력받아 총점 계산 하여 총점이 90 이상이면 '성공' 아니면 '실패' 를 console.log() 함수로 출력하시오.
let pointArray = [];
pointArray.push(Number(prompt("(문제1)첫 번째 점수를 입력하세요.")));
pointArray.push(Number(prompt("(문제1)두 번째 점수를 입력하세요.")));
pointArray.push(Number(prompt("(문제1)세 번째 점수를 입력하세요.")));

console.log(`${pointArray[0] + pointArray[1] + pointArray[2] >= 90 ? "성공" : "실패"}`);

// [지문2] 2개의 정수를 각 입력받아 더 큰수 를 console.log() 함수로 출력하시오.(단] 동일한수 제외)
let numArray1 = [];
numArray1.push(Number(prompt("(문제2)첫 번째 정수를 입력하세요. ")));
numArray1.push(Number(prompt("(문제2)두 번째 정수를 입력하세요. ")));

console.log(`두 개 정수 중 가장 큰 수는 ${numArray1[0] > numArray1[1]  ? numArray1[0] : numArray1[1] } 입니다.`);

// [지문3] 3개의 정수를 각 입력받아 가장 큰수 를 console.log() 함수로 출력하시오.  (단] 동일한수 제외)
let numArray2 = [];
numArray2.push(Number(prompt("(문제3)첫 번째 정수를 입력하세요. "))); 
numArray2.push(Number(prompt("(문제3)두 번째 정수를 입력하세요. "))); 
numArray2.push(Number(prompt("(문제3)세 번째 정수를 입력하세요. "))); 

if(numArray2[0] > numArray2[1] && numArray2[0] > numArray2[2]){
    console.log(`세 개 정수 중 가장 큰 수는 ${numArray2[0]}`);
}else if(numArray2[1] > numArray2[0] && numArray2[1] > numArray2[2]){
    console.log(`세 개 정수 중 가장 큰 수는 ${numArray2[1]}`);
} else{
    console.log(`세 개 정수 중 가장 큰 수는 ${numArray2[2]}`);
}

// [지문4] 3개의 정수를 각 입력받아 오름차순 또는 내림차순 하여 정렬해서 console.log() 함수로 출력하시오.  (단] 동일한수 제외) 
let numArray3 = [];
numArray3.push(Number(prompt("(문제4)첫 번째 정수를 입력하세요. ")));
numArray3.push(Number(prompt("(문제4)두 번째 정수를 입력하세요. ")));
numArray3.push(Number(prompt("(문제4)세 번째 정수를 입력하세요. ")));

if(numArray3[0] > numArray3[1] && numArray3[1] > numArray3[2]){
    console.log(`${numArray3[0]} , ${numArray3[1]} , ${numArray3[2]} `)
} else if(numArray3[0] > numArray3[2] && numArray3[2] > numArray3[0]){
    console.log(`${numArray3[0]} , ${numArray3[2]} , ${numArray3[1]} `)
} else if(numArray3[1] > numArray3[0] && numArray3[0] > numArray3[2]){
    console.log(`${numArray3[1]} , ${numArray3[0]} , ${numArray3[2]} `)
} else if(numArray3[2] > numArray3[1] && numArray3[1] > numArray3[0]){
    console.log(`${numArray3[2]} , ${numArray3[1]} , ${numArray3[0]} `)
} else if(numArray3[2] > numArray3[0] && numArray3[0] > numArray3[1]){
    console.log(`${numArray3[2]} , ${numArray3[0]} , ${numArray3[1]} `)
} else {
    console.log(`${numArray3[1]} , ${numArray3[2]} , ${numArray3[0]} `)
}


// [지문5] 1개의 점수를 입력받아 90점 이상이면 'A등급' 80점이상이면 'B등급' 70점이상 'C등급' 그외 '재시험' 를 console.log() 함수로 출력하시오.
let point4 = Number(prompt("(문제5)점수를 입력하세요."));
if(point4 >= 90) {
    console.log("A등급");
} else if(point4 >= 80){
    console.log("B등급");
} else if(point4 >= 70){
    console.log("C등급")
} else {
    console.log("재시험");
}

// [지문6] 아이디와 비밀번호 입력받아 아이디가 'admin' 이고 비밀번호가 '1234' 이면 '로그인 성공' 아니면 '로그인실패' 를 console.log() 함수로 출력하시오.
let id = prompt("(문제6)아이디를 입력하세요.");
let password = Number(prompt("(문제6)비밀번호를 입력하세요(숫자)"));

console.log(id === 'admin' && password === 1234 ? "로그인 성공" : "로그인 실패" );

// [지문7] 아래와 같이 과일 배열 선언하고 새로운 과일명을 입력받아 fruitList 에 존재하는 과일이면 
// '이미 존재하는 과일입니다' 출력  아니면 배열에 입력받은 과일명 저장 하고 현재 배열을 console.log() 함수로 출력하시오.
// let fruitList = [ '바나나' , '사과' ]
let fruitList = [ '바나나' , '사과', '귤', '메론', '딸기' ];
let fruitName = prompt("(지문7)새로운 과일명을 입력해주세요.");
let searchIndex = fruitList.includes(fruitName);
if(searchIndex){
   console.log( "이미 존재하는 과일입니다.");
} else {
    fruitList.push(fruitName)
    console.log(fruitList);
};


// [지문8] 주민등록번호를 입력받아서 성별이 남자이면 색상변수에 'blue' 을 여자이면 'red' 을 대입 하고 색상변수 를 console.log() 함수로 출력하시오.
let residentNum = prompt("주민등록번호를 입력하세요. ex)001122-1122334");
let residentNumArray = residentNum.split("");
let color = "";
console.log(residentNumArray[7]);

if(residentNumArray[7] == 1 || residentNumArray[7] == 3){
    color = "blue";
}else if(residentNumArray[7] == 2 || residentNumArray[7] == 4){
    color = "red";
}
console.log(`${color}`);

// [지문9] 가위바위보 게임 
// 조건1 : 가위 0 , 바위 1 , 보 2 입니다.
// 조건2 : 플레이어 2 명 입니다.
// 실행조건 : 각 플레이어가 가위,바위,보 중에 한번씩 입력받기 
// 출력조건 : 
// 플레이어1 이겼을때 '플레이어1 승리' 출력 하시오.
// 플레이어2 이겼을때 '플레이어2 승리' 출력 하시오.
// 비겼을경우 '무승부' 를 console.log() 함수로 출력하시오.
let player1 = Number(prompt("첫 번째 플레이어 : 가위 0 , 바위 1 , 보 2 입력"));
let player2 = Number(prompt("두 번째 플레이어 : 가위 0 , 바위 1 , 보 2 입력"));

if((player1 == 0 && player2 == 2) || (player1 == 1 && player2 == 0) || (player1 == 2 && player2 == 1)){
    console.log("플레이어1 승리");
} else if ((player1 == 0 && player2 == 1) || (player1 == 1 && player2 == 2) || (player1 == 2 && player2 == 0)) {
    console.log("플레이어2 승리");
} else {
    console.log("무승부");
}


// [지문10] 아래와 같이 좌석 3개의 상태를 가지는 배열 선언하고 하나의 좌석 순서번호(인덱스) 를 입력받아 
// 빈좌석 이면 '예약성공' 아니면 '예약불가' 출력하시오. 예약상태 구분 방법] 빈좌석 : 'X'  사용중인좌석 : 'O' 

let sheetList = [ 'O' , 'X' , 'O' ];
let index = Number(prompt("좌석 순번을 입력하세요. 0~2"));
if(sheetList[index] ==  "O"){
    console.log("예약 불가능. 사용중인 좌석입니다.");
} else if(sheetList[index] ==  "X"){
    console.log("예약 성공.");
}

// [지문11]주차장 차량 검색대
// 조건1(차량번호) : 
let carArray = [ '250어7142' , '142가7415', '123오4567' ] ;
// 조건2(주차위치) : 
let locationArray = [ 'A1' , 'B3', 'C4' ]              
// 조건3 : carArray, locationArray 배열내 인덱스가 같으면 같은 차량의 정보

console.log(carArray);
console.log(locationArray);
// 조건4 : 차량번호 입력받아 내 차량 위치 찾기 를 반환해주세요.
let carNum = prompt("차량 번호를 입력해주세요.");
if(carArray.includes(carNum)){
    console.log(locationArray[carArray.indexOf(carNum)]);
} 


// - 정답이 필요한 경우 메일/카톡 로 요청하기. 
// - 제출 : itdanja@kakao.com , 12/19(목) 19:00까지
// - 제출파일 : 구현한 JS 파일 및 파일이 위치한 본인 github 상세 주소