/*
    - HTML 마크업에서 이벤트 함수 
        - onXXXX 속성 제공 
        - onclick 속성 : 지정한 마크업을 마우스로 클릭했을때 JS코드 실행
        - 사용법 : <마크업 onclick="JS함수명()" />

    - DOM : document(D:html) object(O:객체) model(m:모델) : html 객체 모델
        - html를 객체로 다룰수 있는 기능 제공한다. html는 순수 문자열 언어 이므로 객체가 없다.
    - document.querySelector('선택자') : 지정한 선택자의 마크업을 JS객체(DOM)로 반환
        .innerHTML  : 마크업시작 과 마크업끝 사이에 HTML 뜻 
        .value : 마크업의 value속성을 뜻 .
*/

// [1] button 클릭시 실행되는 함수 정의/만들기 
function func1( ){ // f s
    console.log( `func1 execute`)
} // f end 

// [2] button(입력버튼) 클릭시 실행되는 함수 정의/만들기 
function func2( ){
    // * input 입력받은 값 가져오기 
    // (1) 특정한 선택자를 이용하여 마크업(DOM)객체 가져오기
    let example1 = document.querySelector('.example1')
    // (2) 가져온 마크업(DOM)객체 에서 value 속성값 가져오기 
    let value = example1.value;
    // (3) 확인 
    console.log( `현재 input마크업 value : ${ value } ` )
}  // f end 

// [3] button( login ) 클릭시 실행되는 함수 정의/만들기 
function login( ){
    // (1) 특정한 선택자를 이용하여 dom객체 가져오기 
    let loginID = document.querySelector('.loginID');
    let loginPW = document.querySelector('.loginPW');
    // (2) 가져온 DOM객체 에서 value 속성값 가져오기 
    let id = loginID.value;
    let pw = loginPW.value;
    // (3) 입력받은 아이디가 admin 이고 비밀번호가 1234 이면 
    if( id == 'admin' && pw == '1234' ){
        alert('로그인 성공');
    }else{
        alert('로그인 실패');
    }
} // f end 

// [4] button 클릭시 실행되는 함수 정의/만들기 
let array = [ '바나나' , '수박' , '오렌지' ]
function func3( ){
    // 1. 특정한 선택자를 이용하여 dom객체 가져오기 
    let arrayBox = document.querySelector('.arrayBox')
    // 2. 출력할 HTML 문자열 구성 
    let html = ``;
    for( let index = 0 ; index <= array.length - 1 ; index++ ){
        html += `<div> ${ array[index] } </div>`
    }
    // 3. 출력할 HTML 문자열을 DOM객체의 innerHTML에 대입하기 
    arrayBox.innerHTML = html;
}