
// [1] 함수 정의 하기
function myFunc( x , y ){
    console.log( 'myFunc 실행');
    return true;
} // f end 

// [2] 함수를 실행 하기 
let result1 = myFunc( 3 , 5 );
console.log( result1 );
console.log( myFunc( 7 , 3 ) );

// [3] 수학 1차함수 정의/만들기 
function 함수1차( a , b , c ){
    let result = (a*b) + c; // 1차함수
    return result;
} // f end 

// [4] 1차함수 실행 하기 
let result2 = 함수1차( 3 , 2 , 7 )
console.log( result2 );

// [5] 믹서기 함수 정의/만들기 
function mixFunc( fruit ){
    let result = fruit + "쥬스"
    return result;
}

// [6] 믹서기 함수 사용하기.
console.log( mixFunc( '바나나') ) ;
console.log( mixFunc( '딸기') );

// [실습1] prompt() 함수로 두개의 정수를 입력받아 
// (정의한) 덧셈함수에 입력받은 값을 전달하여 결과를 출력하시오.

// (1) 덧셈 함수 만들기 , 매개변수 x,y 2개 , 반환값은 두 매개변수를 더한값 
function 덧셈함수( x , y ){
    let result = x + y;
    return result;
}
// (2) 덧셈 함수 사용/호출
console.log( 덧셈함수( 3 , 5 ) ) ;      // 8
console.log( 덧셈함수( 10 , 5 ) ) ;     // 15

// (3) 입력받은 값을 함수의 인수로 사용.
let value1 = Number( prompt('정수1 : ') )
let value2 = Number( prompt('정수2 : ') )

console.log( 덧셈함수( value1 , value2 ) )

// [실습2] 뺄셈함수, 곱셈함수 를 정의하고 사용 하시오.
function 뺄셈함수( x , y ){ // [매소드 정의 ] : function 함수명(){ 로직; retun 반환값 }
    let result = x - y;
    return result;
} // f end
function 곱셈함수( x , y ){
    let result = x * y
    return result
}
console.log( 뺄셈함수(10 , 5 ) )
console.log( 덧셈함수( 10 , 2 ) )







