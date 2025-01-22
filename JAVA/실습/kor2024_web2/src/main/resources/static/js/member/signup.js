
const onSignup = () => {
    console.log("signup 함수 실행");

    // 1. input dom을 가져온다.
    let midInput = document.querySelector('.midInput'); console.log(midInput);
    let mpwdInput = document.querySelector('.mpwdInput'); console.log(mpwdInput);
    let mpwdConfirmInput = document.querySelector('.mpwdConfirmInput'); console.log(mpwdConfirmInput);
    let mnameInput = document.querySelector('.mnameInput'); console.log(mnameInput);
    let memailInput = document.querySelector('.memailInput'); console.log(memailInput);

    // 2. dom의 입력받은값(value)를 가져온다.
    let mid = midInput.value;  console.log(mid);
    let mpwd = mpwdInput.value; console.log(mpwd);
    let mpwdConfirm = mpwdConfirmInput.value; console.log(mpwdConfirm);
    let mname = mnameInput.value; console.log(mname);
    let memail = memailInput.value; console.log(memail);

    // ++다양한 유효성 검사 필요

    // 3.입력받은 값들을 서버에 보낼 각체 만들기.
    let memberDto = {
        "mid" : mid,
        "mpwd" : mpwd,
        "mname" : mname,
        "memail" : memail
    }
    console.log(memberDto);

    let option = {
        method: 'POST',
        headers : {'Content-Type' : 'application/json'},
        body: JSON.stringify(memberDto)
    };

    fetch("/member/signup.do", option)
        .then(response => response.json())
        .then(data => {
            if( data == true) { 
                alert("가입 등록 완료");
                location.href="/member/login";
            } else {
                alert("회원가입 실패")
                // document.querySelector('.mnidInput').value = '';
                // document.querySelector('.mpwdInput').value = '';
                // document.querySelector('.mpwdConfirmInput').value = '';
                // document.querySelector('.mnameInput').value = '';
                // document.querySelector('.memailInput').value = '';
            }
            console.log(date)
        })
        .catch(error => console.log(error))
    
    
}