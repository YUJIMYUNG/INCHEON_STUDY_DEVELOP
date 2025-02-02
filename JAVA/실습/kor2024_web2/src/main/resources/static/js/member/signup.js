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

/*
// 1. 프로필사진 업로드 전 회원가입 함수

// const onSignup = () => {
//     console.log("signup 함수 실행");

//     // 1. input dom을 가져온다.
//     let midInput = document.querySelector('.midInput'); console.log(midInput);
//     let mpwdInput = document.querySelector('.mpwdInput'); console.log(mpwdInput);
//     let mpwdConfirmInput = document.querySelector('.mpwdConfirmInput'); console.log(mpwdConfirmInput);
//     let mnameInput = document.querySelector('.mnameInput'); console.log(mnameInput);
//     let memailInput = document.querySelector('.memailInput'); console.log(memailInput);

//     // 2. dom의 입력받은값(value)를 가져온다.
//     let mid = midInput.value;  console.log(mid);
//     let mpwd = mpwdInput.value; console.log(mpwd);
//     let mpwdConfirm = mpwdConfirmInput.value; console.log(mpwdConfirm);
//     let mname = mnameInput.value; console.log(mname);
//     let memail = memailInput.value; console.log(memail);

//     // ++다양한 유효성 검사 필요

//     // 3.입력받은 값들을 서버에 보낼 각체 만들기.
//     let memberDto = {
//         "mid" : mid,
//         "mpwd" : mpwd,
//         "mname" : mname,
//         "memail" : memail
//     }
//     console.log(memberDto);

//     let option = {
//         method: 'POST',
//         headers : {'Content-Type' : 'application/json'},
//         body: JSON.stringify(memberDto)
//     };

//     fetch("/member/signup.do", option)
//         .then(response => response.json())
//         .then(data => {
//             if( data == true) { 
//                 alert("가입 등록 완료");
//                 location.href="/member/login";
//             } else {
//                 alert("회원가입 실패")
//                 // document.querySelector('.mnidInput').value = '';
//                 // document.querySelector('.mpwdInput').value = '';
//                 // document.querySelector('.mpwdConfirmInput').value = '';
//                 // document.querySelector('.mnameInput').value = '';
//                 // document.querySelector('.memailInput').value = '';
//             }
//             console.log(date)
//         })
//         .catch(error => console.log(error))
    
    
// }
*/

// 2. 프로필사진 업로드 기능이 들어간 회원가입 함수
const onSignup = () => {
    console.log("회원가입 함수 실행");

    // document.qwuertSelector로 가져오는 방식을 쓰지 않는다
    // 폼 전체를 한번에 가져오기 (form전송을 위해서)
    
    // 1. 전송할 form dom객체를 가져온다.
    const signupForm = document.querySelector("#signupForm");
    console.log(signupForm); // form전체를 가져왔는지 확인

    // 2. form dom 객체를 byte로 변환한다. new FormData(dom객체) : 지정한 dom객체를 바이트로 반환
    // http 대용량(첨부파일)자료들은 바이너리(바이트) 단위로 전송하므로 JSON전송이 불가능하다.
    const signupFormData = new FormData(signupForm);// 'application/json' 형식이 아닌 'multipart-form'형식
    console.log(signupFormData) 

    // 3. application/json이 아닌 multipart-form 형식의 fetch 설정 방법
    const option = {
        method : 'POST',
        //content-type 을 생략하면 자동으로 multipart-form 으로 설정된다.
        body : signupFormData
    }

    // 4. fetch
    fetch("/member/signup.do", option)
            .then(response => response.json())
            .then(data => {
                if( data == true) { 
                    alert("가입 등록 완료");
                    location.href="/member/login";
                } else {
                    alert("회원가입 실패")
                }
                console.log(date)
            })
            .catch(error => console.log(error))
}