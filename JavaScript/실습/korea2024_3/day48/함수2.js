
// [1] 매개변수 X , 반환값 X , 함수정의  
function func1(  ){ 
    console.log( 'func1 execute');
}
func1( ); // 함수 실행/호출 

// [2] 매개변수 o , 반환값 x , 함수정의
function func2( x , y ){
    console.log( `func2 execute ${ x+y }` ); 
}
func2( 2 , 3 ); // 함수 실행/호출  // 인수값 2 와 3 전달 

// [3] 매개변수 o , 반환값 o , 함수정의 
function func3( x , y ){
    console.log( `func3 execute`)
    let result = x + y 
    return result;
}
let a = func3( 3 , 5 );     // 함수 실행/호출  // 인수값 3 와 5 전달 
console.log( a );   // 8

// [4] 매개변수x , 반환값 o , 함수 정의 
function func4( ){
    console.log( 'func4 execute');
    return 10;
}
let b = func4(); // 함수 실행/호출 
console.log( b ); // 10 

// [실습1] 주어진 숫자가 홀수인지 짝수인지 반환하는 함수를 만드시오.
    // 함수정의 : isEvenOrOdd , 매개변수 : 숫자1개 , 반환값 : Even , Odd 
function isEvenOrOdd( value ){
    if( value % 2 == 0 ){ // 만약에 매개변수값이 2로 나누기 했을때 나머지가 0이면 
        return "Even"
    }else{
        return "Odd"
    }
}
    // 함수실행/사용 : 함수명을 작성하고 소괄호 안에 인수값을 넣는다. 함수 실행결과 반환값을 변수에 저장한다.
let result1 = isEvenOrOdd( 3 );
console.log( result1 );         // Odd
console.log( isEvenOrOdd(4) )   // Even

// [실습2] 주어진 배열에서 가장 큰수를 반환하는 함수를 만드시오.
    // 함수정의 : findMax , 매개변수 : 배열1개 , 반환값 : 배열내가장큰값 
function findMax( arr ){
    let max = 0; // - 최댓값 변수 0으로 초기화 
    for( let index = 0 ; index <= arr.length - 1 ; index++ ){
            // - index는 0부터 배열내 마지막 인덱스까지 1씩 증가 반복 
        if( arr[index] > max ){
            // - 만약에 index번째 요소가 최댓값 변수 보다 크면 
            max = arr[index]; // - index번째 요소를 최댓값 변수에 대입
        }
    } // for end 
    return max; // - 배열내 가장 큰값을 반환하는 함수.
} // f end 

let array1 = [ 3 , 5 , 2 , 1 ];
console.log( findMax( array1 ) ); // 5

let array2 = [ 100 , 1500 , 2100 , 1700 ]
console.log( findMax( array2 ) ); // 2100

// [실습3] 주어진 배열을 오름차순으로 정렬하여 반환하는 함수 만드시오.
    // 함수명 : arrOrderBy() , 매개변수 : 배열1개 , 반환값 : 정렬된배열1개 
function arrOrderBy( arr ){
    for( let index = 0 ; index <= arr.length - 1 ; index++ ){                   // index 요소 : 비교 기준 
        // - index는 0부터 배열의 마지막 인덱스까지 1씩 증가 반복 
        // for중첩 
        for( let index2 = index + 1 ; index2 <= arr.length - 1 ; index2++ ){    // index2 요소 : 비교할 대상 
            if( arr[index] > arr[index2] ){
                // 만약에 index 번째 요소가 index2 번째 요소보다 크면 
                // *스왑* : 두 변수간의 값 교환
                let temp = arr[index];
                arr[index] = arr[index2];
                arr[index2] = temp;
            }
        }
    } // for end 
    return arr; // 반환 
} // f end 

let array3 = [ 3 , 5 , 2 , 1 ];
console.log( arrOrderBy( array3 ) ); // [ 1 , 2 , 3 , 5 ]

// [ if 11문제 , 지문4] 3개의 정수를 오름차순 또는 내림차순 하여 정렬해서 console.log() 함수로 출력하시오.  (단] 동일한수 제외) 
let value1 = 3 ;
let value2 = 5 ;
let value3 = 2 ;

if( value1 > value2 ){ // - 첫번째 값이 두번째 값보다 크면 자리바꿔(스왑).
    let temp = value1; value1 = value2; value2 = temp;
}
if( value1 > value3 ){ // - 첫번째 값이 세번째 값보다 크면 자리바꿔(스왑).
    let temp = value1; value1 = value3; value3 = temp;
}
if( value2 > value3 ){  // - 두번째 값이 세번째 값보다 크면 자리바꿔(스왑).
    let temp = value2 ; value2 = value3 ; value3 = temp;
}
console.log( ` ${ value1 } , ${ value2 } , ${ value3 } `)   // 2 3 5

















