// - fetch( '요청할URL' , 옵션 )                    <--- 자바의 컨트롤러URL 작성.
// .then( respone => respone.json() )  <--- 요청 결과를 JSON(JS객체) 형식으로 변환
// .then( data => { 실행문; } )        <--- 요청 결과후 실행할 코드 작성.
// .catch( error => { 실행문; } )      <--- 예외 발생시 실행할 코드 작성.
// - 옵션 
// { 
//     method : 'GET'/'POST'/'PUT'/'DELETE',                   <---- 4중에 사용할 HTTP메소드를 작성한다. 생략시 GET 이 된다.
//     headers : { 'Content-Type' : 'application/json'} ,      <---- 서버에게 보낼 자료를 json 형식으로 보내기.
//     body : JSON.stringify( 전송할객체 ),                    <--- 서버에게 보낼 객체
// }


function onWrite(){
    console.log('onWrite.load');
    let sampleBoard = {
        "btitle" : "테스트제목",
        "bcontent" : "테스트내용",
        "bwriter" : "작성자",
        "bpwd" : "1234"
    }

    let option = {
        method : 'POST', // http가 제공하는 method 선택
        headers : {'Content-Type' : 'application/json'}, // http데이터 전송시 body사용
        body : JSON.stringify(sampleBoard) // http에 보낼 데이터를 body에 작성
    }

    fetch('/write', option )
        .then(respone => respone.json())
        .then(data => {console.log(data);})
        .catch(error => {console.log(error);})
}

function onFindAll() {
    console.log('onFindAll.load');

    fetch('/findall')
        .then(r => r.json())
        .then(data => {console.log(data)})
        .catch(error => {console.log(error)})
}

function onFindId() {
    console.log('onFindId.load');
    
    let sampleBno = 3;

    fetch(`/findid?bno=${sampleBno}`)
        .then(r => r.json())
        .then(data => {console.log(data)})
        .catch(error => {console.log(error)})
}

function onUpdate() {
    console.log('onUpdate.load');

    let updateSampleBoard = {
        "bno" : 6,
        "btitle" : "프론트에서 수정한 제목",
        "bcontent" : "프론트에서 수정한내용",
        "bwriter" : "작성자수정됨"
    }

    let option2 = {
        method : 'PUT',
        headers : {'Content-Type' : 'application/json'}, 
        body : JSON.stringify(updateSampleBoard)
    }

    fetch('/update', option2)
        .then(r => r.json())
        .then(data => {console.log(data)})
        .catch(error => {console.log(error)})


   
}

function onDelete() {
    console.log('onDelete.load');

    let sampleBno2 = 5;

    fetch(`/delete?bno=${sampleBno2}`, {method : 'delete'})
        .then(r => r.json())
        .then(data => {console.log(data)})
        .catch(error => {console.log(error)})

}