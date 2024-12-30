// fetch('자바컨트롤러URL', 옵션)
// .then(response => response.json())
// .then(date => {응답결과코드})
// .then(error => {오류결과코드})


// 글쓰기 함수
function bwrite(){
    let titleInput = document.querySelector('.titleInput');
    let contentInput = document.querySelector('.contentInput');
    let pwdInput = document.querySelector('.pwdInput');

    let title = titleInput.value;
    let content = contentInput.value;
    let pwd = pwdInput.value;

    let board = {title : title, content : content, pwd: pwd};

    const option = {
        method : 'POST',
        Headers : {'Content-Type' : 'application/json'},
        body : JSON.stringify(board), // input으로부터 입력받은 값들을 JSON형식의 문자열타입으로 전송
    }
    
    fetch('자바컨트롤러URL', option) 
        .then(response => response.json())
        .then(date => {
            // 응답 결과에 따른 메세지 출력
            if(date == true){
                alert("등록 성공했습니다.")
            } else{
                alert("등록 실패했습니다.")
            }
        })
        .then(error => {console.log(error)})
}


// 글출력 함수
function findAll(){

}