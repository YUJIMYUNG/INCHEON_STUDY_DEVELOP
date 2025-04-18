package korweb.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.List;
import java.util.Vector;

@Component
public class AlramServerSocket extends TextWebSocketHandler {
    // 서버소켓에 접속한 클라이언트 명단
    private static final List<WebSocketSession> connectList = new Vector<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("알람 서버소켓 - 클라이언트가 서버에게 접속 요청");

        // 만약에 클라이언트 소켓이 서버소켓과 연동을 성공하면 리스트 담기
        connectList.add(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("알람 서버소켓 - 클라이언트 / 서버 닫힘");

        connectList.remove(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("알림 서버소켓 - 클라이언트롤부터 메세지를 받음");
        System.out.println("받은 내용은 " + message.getPayload());
        System.out.println("보낸 클라이언트의 소켓 정보 " + session);

        session.sendMessage(new TextMessage("Hi Client"));

        // 서버소켓이 특정 클라이언트 소켓으로부터 받은 메세지를 접속된 모든 클라이언트 소켓들에게 보내기
//        for(int i = 0; i < connectList.size(); i++ ) {
//            AlramServerSocket connectedClient = connectList.get(i);
//            connectedClient.sendMessage(message);
//        }
    }
}
