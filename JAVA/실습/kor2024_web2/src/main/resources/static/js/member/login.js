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