<aside>
💡

웹서버(자바) 에서 데이터를 가져오거나 보내기 위해 사용되는 JS함수

</aside>

---

## 사용 목적

1. 데이터를 요청하거나 보낼 때 사용하며 주로 CRUD(REST API) 구축할 때 사용한다.
    - 데이터 요청 (GET) : 서버에 데이터를 가져오기 위한 HTTP 메소드 규약
    - 데이터 전송 (POST) : 서버에 (저장)데이터를 보내기 위한 HTTP 메소드 규약
    - 데이터 수정 (PUT) : 서버에 (수정)데이터를 보내기 위한 HTTP 메소드 규약
    - 데이터 삭제 (DELETE) : 서버에 데이터를 삭제하기 위한 HTTP 메소드 규약
2. 비동기 통신과 동기 통신을 지원한다.
    - 비동기 : 요청 보내고 올 때까지 다른 작업 수행(병행처리)
    - 동기 : 요청 보내고 응답이 올 때까지 다른 작업을 대기 상태(직렬처리)

## 생활속 비동기(동시처리)

### 예시)

1. 유튜브 시청하면서 댓글 작성하는것
2. SNS에서 사진을 보면서 메시지(DM)를 전송 하는것
    - REACT(페이스북 회사)
3. 싱글페이지(HTML 1개 프로젝트), 페이지 전환시 부드럽다, 로딩 빠르다.
    - AJAX, fetch, axios 함수

## 형태

- fetch(통신할 URL, option)
    
    .then(response ⇒ respose.json())
    
    .then(datea ⇒ {} )
    
    .catch(error ⇒ {} )
    
    ```jsx
    fetch( '요청할URL' , 옵션 )             // 자바의 컨트롤러URL 작성.
      .then( respone => respone.json() ) // 요청 결과를 JSON(JS객체) 형식으로 변환
      .then( data => { 실행문; } )         // 요청 결과후 실행할 코드 작성.
      .catch( error => { 실행문; } )       // 예외 발생시 실행할 코드 작성.
      
    // 옵션
    method : 'GET'/'POST'/'PUT'/'DELETE'. // 4중에 사용할 HTTP메소드를 작성한다. 생략시 GET 이 된다.
    headers : { 'Content-Type' : 'application/json'} ,// 서버에게 보낼 자료를 json 형식으로 보내기.
    body : JSON.stringify( 전송할객체 ),                 // 서버에게 보낼 객체
    ```
    

## fetch 테스트 자료를 제공하는 링크

[JSONPlaceholder - Free Fake REST API](https://jsonplaceholder.typicode.com/)