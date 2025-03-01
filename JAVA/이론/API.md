# API

## 활용 가능한 API

1. 공공데이터포털(정부) : https://www.data.go.kr/
2. 여행(정부) : [https://api.visitkorea.or.kr](https://api.visitkorea.or.kr/)
3. 영화(정부) : https://www.kobis.or.kr/kobisopenapi/homepg/main/main.do
4. 부동산(정부) : https://rt.molit.go.kr/
5. 카카오API(로그인/지도) : https://developers.kakao.com/
6. 네이버API : https://developers.naver.com/main/
7. 결제API : https://portone.io/korea/ko

## 공공데이터 포털

> 국가에서 보유한 정보/데이터 제공하는 홈페이지
> 

## 카카오지도 API

[Kakao 지도 API](https://apis.map.kakao.com/web/)

### 가이드

**준비하기**

1. [*카카오 개발자사이트](https://developers.kakao.com/)* (https://developers.kakao.com) 접속
    1. 로그인
    2. 내 에플리케이션 클릭
    3. 어플리케이션 추가하기
    4. 내용 입력 후 저장
2. 개발자 등록 및 앱 생성
3. 웹 플랫폼 추가: 앱 선택 – [플랫폼] – [Web 플랫폼 등록] – 사이트 도메인 등록
4. 사이트 도메인 등록: [웹] 플랫폼을 선택하고, [사이트 도메인] 을 등록합니다. (예: http://localhost:8080
5. 카카오맵 사이드바에서 활성화 ON으로 설정
6. 페이지 상단의 [JavaScript 키]를 지도 API의 appkey로 사용합니다.
7. 앱을 실행합니다.

**시작하기**

1. 지도 담을 영역 설정 :  `<div id**=**"map" style**=**"width:500px;height:400px;"></div>`
2. 실제 지도를 그리는 Javascript API를 불러오기 : 

`<script type**=**"text/javascript" src**=**"//dapi.kakao.com/v2/maps/sdk.js?appkey=발급받은 APP KEY를 넣으시면 됩니다."></script>`

- 위 script 코드는 개발자 js 코드보다 위에 있어야한다.
1. 지도를 띄우는 코드 붙여넣기

```jsx
var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
var options = { //지도를 생성할 때 필요한 기본 옵션
	center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
	level: 3 //지도의 레벨(확대, 축소 정도)
};

var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
```

# 웹소켓

> ws프로토콜을 기반으로 클라이언트(유저/JS) 와 서버(서버/Spring/Nodes.js) 사이에 지속적인 양방향 연결을 해주는 것으로 지속적인 양방향 연결이 가능하고 상태를 유지한다.
> 

### 용어

- 소켓 : 통신의 종착점(엔드포인트 = 통신을 주고 받을때 도착 위치)
→ 클라이언트 소켓과 서버 소켓으로부터 최초 연결 요청

### 구조

1) 클라이언트 소켓과 서버소켓 간의 연결
→ 클라이언트 소켓 ————————— 서버 소켓
→ 클라이언트 소켓이 서버 소켓으로 최초 연결(접속) 요청
→ 서버 소켓이 클라이언트 소켓의 요청을 등록(바인딩) : 접속목록 : [클라이언트소켓A,클라이언트 소켓B]
→ 클라이언트 접속 요청 허가 

2) 클라이언트 소켓과 서버 소켓간의 메세지 주고받기
→ 서버 소켓에 등록(상태유지)된 클라이언트 소켓이 서버소켓에게 메세지 전송
→ 서버 소켓에 등록(상태유지)된 클라이언트 소켓에게 서버소켓이 메시지 전송

* 누가 먼저 할것 없이 양방향 연결이므로 먼저 메시지를 보낼 수 있다.

### 활용처

- (HTTP가 못하는것) 실시간 처리 (채팅, 알림, 배민(라이더 위치), 실시간 보안, 관제 등)
- HTTP와 다른점 : 웹소켓은 서버와 클라이언트가 서로 연결된 구조이므로 요청이 없어도 서로 양뱡향 통신이 가능하다.

### 구현

<aside>
💡

JS 클라이언트 소켓 구현 - JS 내장 클래스인 WevSocket

</aside>

1. JS에 new WebSocket(’서버소켓주소’) 이용하여 소켓을 생성한다.
2. 주요 속성과 함수들
`생성한소켓.onopen(event) ⇒ { 서버소켓과 접속 성공시 로직 } ;
생성한소켓.onclose(event) ⇒ { 서버소켓과 접속 끊길시 로직 } ;
생성한소켓.onerror(event) ⇒ { 서버소켓과 에러가 발생했을 때 로직 } ;
생성한소켓.onmessage(event) ⇒ { 서버소켓으로부터 메세지를 받았을 때 로직 } ;`
3. event : 해당하는 이벤트의 정보가 들어있는 객체
4. send() : 텍스트만 전송 가능. JSON() 불가능

<aside>
💡

JAVA(Spring)서버 소켓 구현

</aside>

1. gradle에 webSocket 라이브러리 의존성 추가
2. 스프링 컨테이너에 웹소켓 주소 매핑을 등록한다.
    1. 클레스명 
    `implements WebSocketConfigurer{}`
    2. 추상메소드 구현하기
    `public void registerWebSocketHandlers(WebSocketHandlerRegistry registry)`

```java
package korweb.config;

import korweb.controller.ChatServerSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration // 해당 클래스를 스프링 컨테이너 빈(객체) 등록
@EnableJpaAuditing // 웹 소켓을 스프링 컨테이너 빈(객체) 등록
public class WebSocketConfig implements WebSocketConfigurer {
    
    // 서버 소켓 역할을 하는 컨트롤러 클래스/겍체 생성
    @Autowired private ChatServerSocket chatServerSocket;
    
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        //registry.addHandler(매핑할클래스객체 변수명, "서버소켓주소정의");
        registry.addHandler(chatServerSocket, "/chat");
    }
}

```

1. 서버소켓을 아래와같이 로직 구현

```java
package korweb.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

// TextWebSocketHandler 클래스 상속받기
@Component // 현재 클래스를 빈(객체) 등록
public class ChatServerSocket extends TextWebSocketHandler {
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("클라이언트가 서버에게 접속 요청을 함");
    }
}

```

1. 주요 메서드
    - `afterConnectionEstablished` : 클라이언트 소켓이 서버소켓에 연동(접속)을 성공했을 때 실행되는 함수
    - `afterConnectionClosed` : 클라이언트 소켓이 서버소켓과 연동(접속)이 끊겼을때 실행되는 함수.
    - `handleTextMessage` : 클라이언트 소켓이 서버소켓에게 메시지를 보내왔을 때 실행되는 함수

<aside>
💡

JS(클라이언소켓) 와 spring(서버소켓) 통신

</aside>

1. 두 소켓간의 연동 과정
    1. 유저는 chat.html로 접속하면 chat.js 에 있는 지정된 주소로 웹서버에게 연동 요청한다.