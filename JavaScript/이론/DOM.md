<aside>
💡

DOM

</aside>

## Document 타입

<aside>
💡

Document(HTML) Object(객체) Model(모형물체)

HTML의 마크업들을 객체로 다루기 위한 API

JS회사에서는 미리 만들어진 HTML 조작 관련 객체 제공

</aside>

1. 주요 객체와 속성
    1. document : 현재 JS가 포함된 HTML 문서의 전반적인 정보를 갖는 객체
    
    ```jsx
    document.querySelector('CSS선택자');
    // html문서 내 css선택자의 마크업을 (DOM)객체로 반환하는 함수.
    // 만일 동일한 선택자 다수일때는 첫번째 마크업을 가져온다.
    
    document.querySelectorAll('CSS선택자');
    // html문서내 css선택자의 모든 마크업 DOM객체들을 배열로 반환하는 함수.
    
    document.querySelector('class명');
    
    document.querySelector('id명');
    ```
    
    b. 속성
    
    ```jsx
    // 1. value
    // 지정된 DOM객체의 value속성값 호출 / 대입
    // 사용 가능한 마크업 : input, select, textarea 등
    // 사용 불가능한 마크업 : div, table, span 등
    document.querySelector().value; // 호출
    document.querySelector().value = '새로운값' ; // 대입
    
    // 2. innerHTML
    // 지정된 DOM객체의 시작마크업과 끝마크업 사이
    // 마크업 사이의 html문자열 호출 / 대입
    // 사용 가능한 마크업 : div, span, table 등
    // 사용 불가능한 마크업 : input, br, img 등
    document.querySelector().innerHTML;
    document.querySelector().innerHTML = '새로운값' ; // 대입
    
    // 3. style
    // 지정된 DOM객체의 style속성을 이용한 css조작
    document.querySelector().style; //호출
    document.querySelector().style  = 'CSS문법' ; //대입
    
    // 4. src
    // 지정된 마크업의 src속성값 호출/대입
    // 사용 가능한 마크업 : img, audio, video
    document.querySelector().src; // 호출
    document.querySelector().src = '파일명'; // 대입
    ```
    

- document.Dom Tree (HTML문서의 마크업 구조)
    
    ```jsx
    document 
    	<html>
    		<head>
    			<title>
    			<style>
    		<body>
    			<div>
    				<span>
    			<table>
    ```
    

## Element타입

<aside>
💡

</aside>

1. 주요 함수
    1. appendChile(태그)
    2. insertAdjacentHTML(position, text)
        - `beforebegin` : `element` 의 바로 앞에 삽입
        - `afterbegin` : `element` 의 첫 번째 자식 앞에 삽입
        - `beforeend` : `element` 의 마지막 자식 뒤에 삽입
        - `afterend` : `element` 의 바로 뒤에 삽입
2. 주요 속성