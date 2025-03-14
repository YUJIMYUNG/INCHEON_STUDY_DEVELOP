// ==================== 웹소켓 활용 알림기능 =======================

// 부트스트랩- toast 기능
const toastTrigger = document.getElementById('liveToastBtn')
const toastLiveExample = document.getElementById('liveToast')

if (toastTrigger) {
  const toastBootstrap = bootstrap.Toast.getOrCreateInstance(toastLiveExample)
  toastTrigger.addEventListener('click', () => {
    toastBootstrap.show()
  })
}



// 1. 클라이언트 웹소켓
const clientSocket = new WebSocket('ws://localhost:8080/socket/server2');
console.log("로그인알림 클라이언트 웹소켓" + clientSocket);

// 2. 클라이언트 웹소켓 속성
    // 만약에 클라이언트 웹소켓이 서버소켓과 연결을 성공했을 때 실행될 때
clientSocket.onopen = (event) => {
    console.log('로그인알림 서버소켓 연동 성공')
}

clientSocket.onclose = (event) => {
    console.log('로그인알림 서버소켓과 연동이 닫힘')
}

clientSocket.onerror = (event) => {
    console.log('로그인알림 서버소켓과 에러 발생')
}

clientSocket.onmessage = (event) => {
    console.log('로그인알림 서버소켓으로부터 메세지를 받음')
    console.log(event.data);
}








// ==================== 로그인 / 회원가입 ========================


// 1. 로그인 정보 요청 함수
const getLoginMid = () => {
    // 1. fetch 함수를 활용하여 현재 로그인 상태를 체크
    const option = {method: 'GET'}

    // 로그인 상태에 따라 버튼 활성화 여부 다르게 표현
    let memberBox = document.querySelector(".memberBox");
    let html = '';

    fetch('/member/login/myinfo.do', option)
        // .then(response => response.json())
        .then(response => response.json()) // spring controller에서 string 타입으로 반환할 경우에는 Text()로 반환해야한다.
        .then(data => {
            console.log(data);

            console.log("로그인 상태");
            // 로그아웃 버튼, 마이페이지버튼, 로그인된 아이디, 로그인된 아이디의 포인트 정보 활성화
            html += `
            <ul class="navbar-nav me-auto mb-2 mb-lg-0 memberBox">
                <li class="nav-item"> 
                    <img src="${data.mimg.includes('http') ? data.mig : "/img/"+data.mimg}" style="width:70px; border-radius:20px; padding :1px; object-fit:cover; border:1px solid #bfbebe;" />
                    ${data.mid} 님
                    <span class="pointbox"></span>
                    </li>
                <li class="nav-item"><a class="nav-link" href="#" onclick="logout()">로그아웃</a> </li>
                <li class="nav-item"><a class="nav-link" href="/member/info">마이페이지</a></li>
            </ul>`;
        

            // 출력하기delete.do
            memberBox.innerHTML = html;

            // 포인트 지급 함수 불러오기
            myPointInto();
        }
        
        ) 
        .catch(error => {
            console.log(error)
            console.log("비로그인 상태")
            // 회원가입 버튼, 로그인 버튼 활성화
            html += `
                <ul class="navbar-nav me-auto mb-2 mb-lg-0 memberBox">
                    <li class="nav-item"><a class="nav-link" href="/member/signup">회원가입</a> </li>
                    <li class="nav-item"><a class="nav-link" href="/member/login">로그인</a></li>
                </ul>`;

                // 출력하기
            memberBox.innerHTML = html;
            }
        
        )
} // getLoginMid end

// JS 실행될 때, 로그인 정보 요청 함수 호출
getLoginMid();


// 시큐리티 이후 로그아웃
const logout = () => {
    // 시큐리티 이후에는 fetch로 로그아웃이 아닌 get방식으로 시큐리티 로그아웃을 처리한다.
    location.href = "/member/logout.do";
}

// 시큐리티 전
// 로그아웃 함수
// const logout = () =>{
//     console.log("로그아웃")

//     const option = {method : 'GET'}
//     fetch('/member/logout.do', option)
//         .then(response => response.json())
//         .then(data => {
//             console.log(data);
//             if(data == true) {
//                 alert('로그아웃 성공')
//                 location.href= '/';
//                 getLoginMid(); // 헤더 상태를 다시불러오기
//             } else {
//                 alert("로그인 실패")
//             } // if-else end
//         })
//         .catch(error => console.log(error));
// }// logout()end


// [3] 내 포인트 함수
const myPointInto =  ( ) =>{
    // 1. fetch option
    const option = { method : 'GET' }
    // 2. fetch
     fetch( '/member/point/info.do' , option )
        .then( response => response.json() )
        .then( data => {
                  // 1. 출력할 위치 DOM 가져오기
              let pointbox = document.querySelector('.pointbox')
                  // 2.
              let html =`${ data } Point `
                // 3. 출력하기
              pointbox.innerHTML = html;
        })
        .catch( e => { console.log(e); })
}