// 1. 수정페이지 들어왔을때 수정 하기전 기존 정보 보여주기
const getMyinfo = () => {
    console.log("마이페이지 함수 실행")
    
    fetch('/member/login/myinfo.do')
        .then( response => response.json())
        .then( data => {
            if(data != "") { // 응답 결과가 존재하면
                document.querySelector('.midInput').value = data.mid;
                document.querySelector('.mnameInput').value = data.mname;
                document.querySelector('.memailInput').value = data.memail;
            } 
        })
        .catch (error => console.log(error))
}

getMyinfo(); //update.html이 열릴 때 함수 실행

// 2. 수정 버튼 클릭했을 때 수정 처리
const onUpdateAccount = () =>{
    console.log("정보 수정 함수 실행")

    // 1. 입력받은 input value 가져오기
    let mname = document.querySelector('.mnameInput').value; console.log(mname);
    let memail = document.querySelector('.memailInput').value; console.log(memail);

    // 2. 객체화
    let dataObj = {mname : mname, memail : memail};

    const option = {
        method : 'PUT',
        headers : {'Content-Type' : 'application/json'},
        bodt : JSON.stringify(dataObj)
    }

    fetch('/member/login/update.do', option)
        .then(response => response.json())
        .then(data => {
            if(data) {
                alert("수정 성공")
            } else{
                alert('수정 실패')
            }
        })
        .catch(error => console.log(error))
}