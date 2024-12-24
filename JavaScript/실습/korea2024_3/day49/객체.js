// [1] 객체 선언하기
// { }

// [2] 객체 생성시 속성 정의하기
// { 속성명1 : 10 , 속성명2 : 'HELLO' };

// [3] 생성한 객체를 변수에 대입하기 
let 객체변수1 = { 속성명1 : 10 , 속성명2 : 'JAVA'};

// [4] 객체를 호출하기 
객체변수1;
console.log( 객체변수1 ); // {속성명1: 10, 속성명2: 'JAVA'}

// [5] 객체의 특정 속성 값 호출하기 
객체변수1.속성명1;
console.log( 객체변수1.속성명1 ) // 10

// [6] 객체의 특정 속성 값 수정하기
객체변수1.속성명1 = 20;

// [7] 객체의 특정 속성 삭제하기.
delete 객체변수1.속성명1;
console.log( 객체변수1 );   // {속성명2: 'JAVA'}

// [8] 객체내 다양한 속성값들 
let 객체변수2 = {
    속성명1 : 10  , 
    속성명2 : 'HI' ,
    속성명3 : false , 
    속성명4 : null,
    속성명5 : [ 1 , 2 , 3 , 4 ],
    속성명6 : function add(){} ,
    속성명7 : { 서브속성1 : 10 }
}

// [실습1] : 게시판를 구현하기 위한 아래와 같은 정보를 게시물객체로 표현 하시오.
// 제목 : '안녕하세요' 
// 내용 : 'js 처음입니다'
// 작성자 : '유재석'
// 조회수 : 3 
// 작성일 : '2024-12-23'
let board = {
    title : '안녕하세요.',
    content : 'JS는 처음입니다',
    writer : '유재석' , 
    view : 3 , 
    date : '2024-12-23'
}

// [실습2] : 회원를 구현하기 위한 아래와 같은 정보를 회원객체로 표현하시고 출력하시오.
    // 객체의 닉네임과 나이를 출력하는 코드 작성하시오.
// 아이디 : qwe;
// 비밀번호 : 1234
//닉네임 : '유재석'
// 나이 : 40
let member = {    id : 'qwe' , pw : '1234' , name : '유재석' , age : 40  }
console.log( member.name ); // 유재석
console.log( member.age );  // 40

// [실습3] : prompt로 부터 국어,영어,수학 점수를 정수로 입력받아 score 객체에 저장하시오.
let kor = Number( prompt('국어 : ') ) ;
let math = Number( prompt( '수학 : ') ) ;
let eng = Number( prompt( '영어 : ' ) ) ;

let score = {  kor : kor  , math : math , eng : eng }
console.log( score );
let sum = score.kor + score.math + score.eng
let avg = sum / Object.keys( score ).length; 

console.log( Object.keys( score ) )