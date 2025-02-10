console.log(" view.js open");

// 1. 개별 게시물 조회하기
const onFind = () => {

    // 1. 현재 보고자 하는 게시물의 번호를 찾는다. 
        // 사용자가 클릭한 게시물 번호 찾기
        // board/view?bno=? , 즉 Url경로상의 쿼리스트링 bno가 존재함
    //console.log(new URL()) // new URL() : url 정보를 담는 객체를 생성
    //console.log(new URL(location.href)) //new URL(location.href) : 현재 페이지의 Url 정보를 담은 객체를 생성
    //console.log(new URL(location.href).searchParams) // 현재 페이지의 Url 정보중에 매개변수를 반환 속성
    
    const bno = new URL(location.href).searchParams.get('bno');

    //2. fetch
    fetch('/boar/find.do?bno=${bno}')
        .then(r=> r.json)
        .then(data => {
            console.log(data);
            document.querySelector('.mimgbox') .innerHTML = data.mid;
            document.querySelector('.midbox') .innerHTML = data.bview;
            document.querySelector('.bviewbox') .innerHTML = data.bview;
            document.querySelector('.cdatebox') .innerHTML = data.cdate;

            document.querySelector('.btitlebox') .innerHTML = data.btitle;
            document.querySelector('.bcontentbox') .innerHTML = data.bcontent;

        })
        .catch(e => {console.log(e)})
}



//페이지가 열릴 때 개별 게시물 조회 함수 실행
onFind();

// 2. 댓글 쓰기 요청함수
// 실행조건 :댓글 게시 버튼을 클릭했을 때
const onReplyWrite = () => {

    //1. 입력받은 값 가져오기
    const rcontentInput = document.querySelector(".rcontentInput");
    const rcontent = rcontentInput.value;

    //2. 현재 게시물 번호
    const bno = new URL(location.href).searchParams('bno')

    //3. 객체화
    const object = {rcontent: rcontent, bno : bno}
    
    //4. fetch
    const option = {
        method: 'POST',
        headers : {'Content-Type' : 'application/json'},
        body : JSON.stringify(object)
    }

    fetch('/reply/write.do', option)
        .then(r => r.json())
        .then(data => {
            if(data == true){
                alert("댓글등록 성공")
                onReplyFindAll();//댓글쓰기 성공시 댓글 전체조회 함수 실행
            } else {
                alert("댓글등록 실패")
            }
        })
        .catch(e => {console.log(e)})
}





// 3. 개별 게시물의 댓글 조회 요청함수
const onReplyFindAll = () => {

}