console.log('chat.js open')




// ============ 비회원제 익명 채팅 ===============
// 1) 익명 아이디 만들어주기
// Math.random : 0 ~ 1 사이의 난수 생성 함수
//  (Math.random() * 끝 값 ) + 시작값 : 1부터 끝값 전까지의 난수
let randomNo = Math.floor(Math.random() * 1001) + 1; // 1~1000사이의 난수 
let nickName = `익명${randomNo}`;










// 1. 클라이언트 웹소켓
const clientSocket = new WebSocket('ws://localhost:8080/socket/server');
console.log(clientSocket);

// 2. 클라이언트 웹소켓 속성
    // 1). 만약에 클라이언트 웹소켓이 서버소켓과 연결을 성공했을 때 실행되는 함수 구현
clientSocket.onopen = (event) => {
    console.log('서버소켓에 연동 성공')

    // + 클라이언트가 서버소켓에 접속했을 때
    //  type : 메세지의 종류 , message : 메세지 본문
    let msg = {'type' : 'alram', 'message' : `${nickName}님이 입장하셨습니다.`}
    // socket은 문자열만 전송이 가능하므로 JSON.stringfy()를 사용한다.
    clientSocket.send(JSON.stringify(msg))
}
    // 2). 만약에 클라이언트 웹소켓이 서버소켓과 연결이 닫혔을 때 실행되는 함수 구현
clientSocket.onclose = (event) => {
    console.log('서버소켓과 연동이 닫힘')
}
    // 3). 만약에 클라이언트 웹소켓이 서버소켓과에러가 발생했을 때 실행되는 함수 구현
clientSocket.onerror = (event) => {
    console.log('서버켓과 에러 발생')
}
    // 4). 만약에 클라이언트 웹소켓이 서버소켓과에러가 메세지를 받았을 때 실행되는 함수 구현
clientSocket.onmessage = (event) => {
    console.log('서버소켓으로부터 메세지를 받음')
    // 서버로부터 클라이언트가 메시지를 받았을 때
    console.log(event); //받은 메세지 통신 정보 객체
    console.log(event.data); //받은 메시지 본문

    // + 받은 메시지 꺼내서 JSON으로 타입 변환, JSON.parse("문자열")
    const message = JSON.parse(event.data);
    const contentListBox  = document.querySelector('.contentListBox'); //특정한위치에 받은 메시지 출력

    if(message.type == 'alram') { // 메세지 타입이 알람이면
        contentListBox.innerHTML += `
            <div class="alram">
              <span>${message.message}</span>
            </div>
        `
    } else if (message.type == 'msg') { // 메세지 타입이 메시지문구이면
        if(message.from === nickName) { // 메세지 보낸 사람이 현재 nickname 같다면(내가보낸메시지)
            contentListBox.innerHTML += `
                <div class="secontent">
                    <span class="date">${message.date}</span>
                    <span class="content">${message.message}</span>
                </div>
            `
        } else { // 아니면 남이 보낸 메시지 
            contentListBox.innerHTML += `
                <div class="reciveBox">
                <div   class="profileImg" >
                    <img src="/img/default.jpg" />
                </div>
                <div class="recontent">
                    <div class="memberNick">${message.from}</div>
                    <span class="content">${message.message}</span>
                    <span class="date">${message.date}</span>
                </div>
                </div>
            `
        }// if-else end
    }// if-else end

    // 메시지를 표시하고 만약 스크롤이 메세지보다 위에 존재하면 스크롤을 자동으로 최 하단에 배치하게
        // scrollTop = 스크롤바의 상단위치
        // scrollHeight = 스크롤의 전체길이
    contentListBox.scrollTop = contentListBox.scrollHeight;

}

// + 입력상자에서 엔터키를 쳤을 때 메세지 내용 전송
const enterkey = () => {
    if(window.event.keyCode == 13 ) { 
        messageSend();
    }
}

//3. 서버에게 메세지를 보내기
const messageSend = () => {
    // 1. 입력받을 값 가져오기
    const messageInputBox = document.querySelector('.messageInputBox');
    const messageInput = messageInputBox.value; console.log(messageInput)
    // a만약에 함수가 비어있으면 함수 강제종료
    if(messageInput == '') return;

    // + 메세지 구성
    // typd : 메시지 분류, message: 메시지내용, from:보내는 사람, date: 현재날짜/시간
    let msg = { type : 'msg', message : messageInput, from: nickName, date : new Date().toLocaleDateString()}

    // 2. 클라이언트 웹소켓 객체에 .send() 함수 이용한 서버에게 메시지 전송
    clientSocket.send(JSON.stringify(msg));

    // 3. 전송후 입력상자(공백으로)초기화
    messageInputBox.value = '';

}