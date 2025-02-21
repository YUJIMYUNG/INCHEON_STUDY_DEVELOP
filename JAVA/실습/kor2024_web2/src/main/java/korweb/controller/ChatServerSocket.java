package korweb.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.List;
import java.util.Vector;

// TextWebSocketHandler 클래스 상속받기
@Component // 현재 클래스를 빈(객체) 등록
public class ChatServerSocket extends TextWebSocketHandler {

    // 서버소켓에 접속한 클라이언트 명단 필요
    private static final List<WebSocketSession> connectList = new Vector<>();

    // 클라이언트가 들어왔을 떄
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("클라이언트가 서버에게 접속 요청을 함");

        // 만약에 클라이언트소켓이 서버소켓과 연동을 성공하면 리스트 담기
        connectList.add(session);

        // 클라이언트
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("클라이언트 / 서버 닫힘");

        // 만약에 클라이언트 소켓이 서버소켓과 연동이 끊겼을 때 리스트에서 빼기
        connectList.remove(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("클라이언트로부터 메세지를 받음");
        System.out.println("받은 내용은" + message.getPayload()); // 받은 메세지 객체내 본문 반환함수 getPayload()
        System.out.println("보낸클라이언트의 소켓정보" + session);

        // 클라이언트에게 메시지를 보내기
        //session.sendMessage(new TextMessage("안녕 클라이언트"));

        // 서버 소켓이 특정 클라이언트 소켓으로부터 받은 메세지를 접속된 모든 클라이언트 소켓들에게 보내기
        for(int i = 0 ; i < connectList.size() ; i++) {
            WebSocketSession connectedClient = connectList.get(i); // i번째 클라이언트소켓 꺼내기
            connectedClient.sendMessage(message); // 서버소켓이 받은 Message를 모든 소켓들에게 메세지를 전송
        }
    }
}
