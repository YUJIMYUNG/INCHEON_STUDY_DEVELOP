console.log('member.js oopen');

//1. signup함수
function signup(){
    console.log("회원가입 함수 실행됨")

    const midInput = document.querySelector(".midInput");
    const mpwdInput = document.querySelector(".mpwdInput");
    const mnameInput = document.querySelector(".mnameInput");
    const mphoneInput = document.querySelector(".mphoneInput");

    const mid = midInput.value;
    const mpwd = mpwdInput.value;
    const mname = mnameInput.value;
    const mphone = mphoneInput.value;

    const minfo = {
        mid : mid,
        mpwd : mpwd,
        mname : mname,
        mphon : mphone
    }

    const option = {
        method : 'POST',
        headers : {'Content-Type' : 'application/json'},
        body : JSON.stringify(minfo)
    }

    fetch('/signup.do', option)
        .then(r => r.json())
        .then(data => {
            console.log(data)
            if(data){
                alert("회원가입 성공했습니다.");
                location.href='/login' // js에서 페이지 전환하는 함수
            }else{
                alert('회원가입을 실패했습니다.')
            }
        })
        .catch(error => console.log(error))

}


//2. login함수
function login(){
    console.log("로그인 함수 실행 됨")

    const midInput = document.querySelector(".midInput");
    const mpwdInput = document.querySelector('.mpwdInput');

    const mid = midInput.value;
    const mpwd = mpwdInput.value;

    fetch(`/login.do?mid=${mid}&mpwd=${mpwd}`)
        .then(r => r.json())
        .then(data => {
            console.log(data)
            if(data){
                alert('로그인 성공')
                location.href='/login';
            } else {
                alert('로그인 실패')
            }
        })
        .catch(error => console.log(error))

}