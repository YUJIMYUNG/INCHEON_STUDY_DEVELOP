// [1] 반복문을 사용하는 이유
    // 1. 반복되는 코드를 간소화 하기 위해서 
    console.log(`안녕하세요`);
    console.log(`안녕하세요`);
    console.log(`안녕하세요`);
    console.log(`안녕하세요`);
    console.log(`안녕하세요`);
        // 2. 
    for( let i = 1 ; i<=5 ; i++ ){
        // - i는 1부터 5이하까지 1씩증가 반복 
        console.log(`안녕하세요`);
    }
    
    // [2] 반복문 사용시 중요한 부분 , 반복문이 없을때 코드 구상
        // 1. 1부터 5까지 출력하시오. (반복문이 없을때)
    console.log( 1 );
    console.log( 2 );
    console.log( 3 );
    console.log( 4 );
    console.log( 5 );
    // 1. 반복되는 코드         :           console.log(  );
    // 2. 반복되지 않은 코드    :           1 2 3 4 5
    // 3. 반복되지 않은 코드 패턴/규칙 :    1부터 5까지 1씩증가 규칙
        // 2. 1부터 5까지 출력하시오.(반복문이 있을때)
    for( let value = 1 ; value <= 5 ; value++ ){
        // - value는 1부터 5이하까지 1씩증가 반복 
        console.log( value );
    }
    
    // [3] 1부터 10까지 누적합계(모두 더한값) 를 출력하시오.
        // 1. 반복문이 없을때
    let sum = 0 ; // 총합계 변수 
    sum = sum + 1;  sum = sum + 2;  sum = sum + 3;
    sum = sum + 4;  sum = sum + 5;  sum = sum + 6;
    sum = sum + 7;  sum = sum + 8;  sum = sum + 9;
    sum = sum + 10;
    // 반복되는 코드 : sum = sum + 
    // 반복되지 않은 코드 : 1 2 3 4 5 6 7 8 9 10 , let sum = 0 
    // 반복되지 않은 코드의 규칙/패턴 : 
        // let sum = 0   코드는 규칙이없다.
        // 1 2 3 4 5 6 7 8 9 10 : 1부터 10까지 1씩증가
    let sum2 = 0
    for( let value = 1 ; value <= 10 ; value++ ){
        sum2 = sum + value;
    }
    console.log( sum2 );
    
    // [4]  구구단의 2단 를 출력하세요.
    // 1. 반복문 없이
    console.log( ` 2 X 1 = ${ 2*1 } `) 
    console.log( ` 2 X 2 = ${ 2*2 } `) 
    console.log( ` 2 X 3 = ${ 2*3 } `) 
    console.log( ` 2 X 4 = ${ 2*4 } `) 
    console.log( ` 2 X 5 = ${ 2*5 } `) 
    console.log( ` 2 X 6 = ${ 2*6 } `) 
    console.log( ` 2 X 7 = ${ 2*7 } `) 
    console.log( ` 2 X 8 = ${ 2*8 } `) 
    console.log( ` 2 X 9 = ${ 2*9 } `) 
    // 2. 반복문 사용.
    //  반복되는 코드 console.log( ` 2 X  = ${ 2* } `) 
    // 반복되지 않은 코드 : 1 2 3 4 5 6 7 8 9
    // 반복되지 않은 코드의 규칙/패턴 : 1부터 9까지 1씩 증가 반복 
    for( let 곱 = 1 ; 곱<=9 ; 곱++ ){
        console.log( ` 2 X ${곱} = ${ 2*곱 } `) 
    }
    
    // [5] 전체(2단~9단) 구구단 를 출력하세요.
    // 단 규칙 : 2 부터 9 까지 1씩 증가 반복  
    for( let 단 = 2 ; 단<=9 ; 단++ ){
        console.log( 단 )
    }
    // 곱 규칙 : 1 부터 9 까지 1씩 증가 반복 
    for( let 곱 = 1 ; 곱<=9 ; 곱++ ){
        console.log( 곱 )
    }
    // 구구단 이란? 1.단마다 곱 계산인지? O 2.곱마다 단 계산인지? X
        // for문 중첩 : 상-하 관계 , 단FOR문에 곱FOR문을 포함
    for( let 단 = 2 ; 단<=9 ; 단++ ){
        for( let 곱 = 1 ; 곱<=9 ; 곱++ ){
            console.log( `${ 단 } X ${ 곱 } = ${ 단*곱 }` )
        }
    }
    
    // [6] 간단한 직삼각형 출력하시오.
    /*
                        줄      별
            *           1       1  
            **          2       1 2 
            ***         3       1 2 3 
            ****        4       1 2 3 4 
            *****       5       1 2 3 4 5 
            - 줄패턴 : 1부터 5까지 1씩 증가 반복 .
            - 별패턴 : 1부터 현재줄수 까지 1씩증가 반복.    
                -> 줄 마다 별 출력하는지?? O  , 별 마다 줄 출력하는지?? X
    */
    let outHTML = ``;
    for( let line = 1 ; line <= 5 ; line++ ){           // 1. 줄for문
        for( let star = 1 ; star <= line ; star++ ){    // 2. 별for문 
            outHTML += `★`
        } 
        outHTML += `<br/>`
    } // for end 
    
    let body마크업객체 = document.querySelector('body') // * 선택자의 마크업을 JS객체로 반환 
    body마크업객체.innerHTML = outHTML; // JS마크업객체내 HTML 삽입/대입 
    
    // [7] 배열과 반복문 관계 
    let 과일배열 = [ '사과' , '포도' , '딸기' ]
        // - 과일배열내 모든 요소를 하나씩 출력하세요.
    console.log( 과일배열[0] );
    console.log( 과일배열[1] );
    console.log( 과일배열[2] );
        // 반복문 , 반복되는 console.log( 과일배열[ ] ); , 반복되지 않는 0 1 2
    for( let index = 0 ; index<=2 ; index++ ){
        console.log( 과일배열[index] );
    }
    for( let index = 0 ; index<=과일배열.length-1 ; index++ ){
        console.log( 과일배열[index] );
    }
    
    // [8] 반복문 주요 키워드 
    // (1) continue;
    for( let i = 1 ; i <= 5 ; i++ ){ // i는 1부터 5이하까지 1씩증가 반복 
        if( i == 3 ){ continue; } // i가 3이면 증감식으로 이동해,아래코드가 실행되지 않는다.
        console.log( i )    // 1 2 3(continue) 4 5 
    }
    // (2) break;
    for( let i = 1 ; i<=10 ; i++ ){
        if( i == 5 ){ break; }
        console.log( i );   // 1 2 3 4 
    }
    
    
    
