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


const onLogin = () => {
    console.log("로그인 함수 들어옴");
    
    let midInput = document.querySelector(".midInput"); console.log(midInput)
    let mpwdInput = document.querySelector(".mpwdInput"); console.log(mpwdInput)

    let mid  = midInput.value; console.log(mid);
    let mpwd  = mpwdInput.value; console.log(mpwd);

    let loginDto = {
        "mid" : mid,
        "mpwd" : mpwd,
    }
    console.log(loginDto)

    let option = {
        method : 'POST',
        headers : {'Content-Type' : 'application/json'},
        body : JSON.stringify(loginDto)
    };

    fetch("/member/login.do", option)
        .then(response => response.json())
        .then(data => {
            if(data == true) {
                alert("로그인 성공");
                location.href= '/';
            } else {
                alert("로그인 실패")
            }
        })
        .catch(error => console.log(error))
    


}