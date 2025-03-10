document.addEventListener('DOMContentLoaded', function() {
    // 모든 input 필드를 찾아서 이벤트 리스너 추가
    const inputs = document.querySelectorAll('input');
    
    inputs.forEach(input => {
        // 초기 로드시 값이 있으면 used 클래스 추가
        if (input.value) input.classList.add('used');
        
        // input에 포커스가 있거나 값이 있을 때 처리
        input.addEventListener('blur', function() {
            if (input.value.length > 0) {
                input.classList.add('used');
            } else {
                input.classList.remove('used');
            }
        });
    });
});



// 2-1. 로그인 함수, 시큐리티 사용시에는 form 형식
const onLogin = () => {
    console.log("login fucntion on")

    // 1. 로그인 form 가져오기
    const loginForm = document.querySelector(".loginForm");
    // 2. form 데이터로 변경
    const formData = new FormData(loginForm);
    // 3. fetch
    const option = {
        method : 'POST',
        body : formData
    }
    fetch("/member/login.do", option)
        .then(response => response.json)
        .then(data => {
            if(data == true) {
                alert("로그인 성공");
                location.href= '/';
            } else {
                alert("로그인 실패")
            }
        })
        .catch(error => {
            console.log(error)
            alert('시스템 오류 : 관리자에게 문의하세요.')
        })

}


// 2. 로그인 함수 - 시큐리티 사용 전 (JSON 사용하지 않으므로 코드 변경함)
// const onLogin = () => {
//     console.log("로그인 함수 들어옴");
    
//     let midInput = document.querySelector(".midInput"); console.log(midInput)
//     let mpwdInput = document.querySelector(".mpwdInput"); console.log(mpwdInput)

//     let mid  = midInput.value; console.log(mid);
//     let mpwd  = mpwdInput.value; console.log(mpwd);

//     let loginDto = {
//         "mid" : mid,
//         "mpwd" : mpwd,
//     }
//     console.log(loginDto)

//     let option = {
//         method : 'POST',
//         headers : {'Content-Type' : 'application/json'},
//         body : JSON.stringify(loginDto)
//     };

//     fetch("/member/login.do", option)
//         .then(response => response.json())
//         .then(data => {
//             if(data == true) {
//                 alert("로그인 성공");
//                 location.href= '/';
//             } else {
//                 alert("로그인 실패")
//             }
//         })
//         .catch(error => console.log(error))
    
// }