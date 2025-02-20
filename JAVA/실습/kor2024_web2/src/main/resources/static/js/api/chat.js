console.log('chat.js open')
// 1. 클라이언트 웹소켓
const clientSocket = new WebSocket('ws://localhost:8080/socket/server');
console.log(clientSocket);

// 2. 클라이언트 웹소켓 속성
    // 1). 만약에 클라이언트 웹소켓이 서버소켓과 연결을 성공했을 때 실행되는 함수 구현
clientSocket.onopen = (event) => {
    console.log('서버소켓에 연동 성공')
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
    
    const message = event.data; // 받은 메세지 꺼내기
    const messageInputBox  = document.querySelector('.messageInputBox'); //특정한위치에 받은 메시지 출력
    messageInputBox.innerHTML += `
        <div>${message}</div>
    `
}

//3. 서버에게 메세지를 보내기
const messageSend = () => {
    // 1. 입력받을 값 가져오기
    const messageInputBox = document.querySelector('.messageInputBox');
    const messageInput = messageInputBox.value;

    // 2. 클라이언트 웹소켓 객체에 .send() 함수 이용한 서버에게 메시지 전송
    clientSocket.send(messageInput);

    // 3. 전송후 입력상자(공백으로)초기화
    messageInputBox.value = '';

}