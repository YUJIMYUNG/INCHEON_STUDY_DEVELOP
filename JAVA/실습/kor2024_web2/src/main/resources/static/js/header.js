

// 1. 로그인 정보 요청 함수
const getLoginMid = () => {
    // 1. fetch 함수를 활용하여 현재 로그인 상태를 체크
    const option = {method: 'GET'}

    // 로그인 상태에 따라 버튼 활성화 여부 다르게 표현
    let memberBox = document.querySelector(".memberBox");
    let html = '';

    fetch('member/myinfo.do', option)
        // .then(response => response.json())
        .then(response => response.json()) // spring controller에서 string 타입으로 반환할 경우에는 Text()로 반환해야한다.
        .then(data => {
            console.log(data);

            console.log("로그인 상태");
            // 로그아웃 버튼, 마이페이지버튼, 로그인된 아이디, 로그인된 아이디의 포인트 정보 활성화
            html += `
            <ul class="navbar-nav me-auto mb-2 mb-lg-0 memberBox">
                <li class="nav-item"> 
                    <img src="/img/${data.mimg}" style="width:70px; border-radius:20px;" />
                    ${data.mid} 님
                    </li>
                <li class="nav-item"> 현재 포인트 : ${data}</li>
                <li class="nav-item"><a class="nav-link" href="#" onclick=logout()>로그아웃</a> </li>
                <li class="nav-item"><a class="nav-link" href="/member/info">마이페이지</a></li>
            </ul>`;
        

            // 출력하기
            memberBox.innerHTML = html;
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

// 로그아웃 함수
const logout = () =>{
    console.log("로그아웃")

    const option = {method : 'GET'}
    fetch('/member/logout.do', option)
        .then(response => response.json())
        .then(data => {
            console.log(data);
            if(data == true) {
                alert('로그아웃 성공')
                location.href= '/';
            } else {
                alert("로그인 실패")
            } // if-else end
        })
        .catch(error => console.log(error));
}// logout()end


