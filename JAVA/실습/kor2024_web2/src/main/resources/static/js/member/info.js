// 1. 마이페이지에서 (로그인된) 내 정보 불러오기 
const getMyinfo = () => {
    console.log("마이페이지 함수 실행")
    
    fetch('/member/login/myinfo.do')
        .then( response => response.json())
        .then( data => {
            if(data != "") { // 응답 결과가 존재하면
                document.querySelector('.midInput').value = data.mid;
                document.querySelector('.mnameInput').value = data.mname;
                document.querySelector('.memailInput').value = data.memail;
                document.querySelector('.mpointInput').value = data.mpoint; // 현재 포인트 정보도 가져오게하기 
            } 
        })
        .catch (error => console.log(error))
}

getMyinfo(); //info.html이 열릴 때 함수 실행


// 2. 마이페이지에서 (로그인된) 회원탈퇴 요청하기
const onDeleteMyAccount = () => {
    console.log("회원탈퇴 함수 실행")


    // 예, 아니오 형식으로 탈퇴 여부를 묻고 아니요를 클릭하면 탈퇴를 중지한다. 
    let result = confirm('정말 탈퇴 하실건가요 ? ');
    if( result == false ){ return ;}
    
    const option = {method : 'DELETE'}
    
    fetch('/member/login/delete.do', option)
        .then(response => response.json())
        .then( data => {
            if(data) {
                alert("탈퇴 처리 되었습니다.");
                location.href = '/';
            } else {
                alert('탈퇴 실패')
            } // if-else end
        })
        .catch(error => console.log(error))
}
