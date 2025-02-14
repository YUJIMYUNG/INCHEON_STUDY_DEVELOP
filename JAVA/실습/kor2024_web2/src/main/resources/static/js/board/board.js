// * js가 열렸는지 확인하기 위해
console.log( 'board.js open' )
// * 현재 URL 의 쿼리스트링 매개변수 가져오기
    // 현재 페이지의 URL 정보가 담긴 객체 생성
console.log( new URL( location.href ) )
    // 현재 페이지의 URL 쿼리스트링 정보 속성 반환
console.log( new URL( location.href ).searchParams )
    // 현재 페이지의 URL 쿼리스트링 속성 중 'cno' 속성값 반환
console.log( new URL( location.href ).searchParams.get('cno') )

// [1] 게시물 전체 조회 요청 함수
const findAll = ( ) => {
    // 1. 현재 페이지 URL 에서 매개변수 cno 값 구하기
    const cno = new URL( location.href ).searchParams.get('cno')

    // 현재 페이지 url에서 매개변수 페이지번호 구하기
    let page = new URL(location.href).searchParams.get('page');
    // 만약에 페이지가 없으면 1페이지로 설정
    if( page == null) {
        page = 1;
    }


    // * 검색필드와 검색어
    let key = new URL(location.href).searchParams.get('key');
    if(key == null) key = ''; //key 가 없으면 공백으로 설정
    let keyword = new URL(location.href).searchParams.get('keyword');
    if(keyword == null ) keyword = ''; // keyword가 없으면 공백으로 설정



    // 2. fetch option
    const option = { method : 'GET' }
    // 3. fetch + 페이지번호 전송
    fetch( `/board/findall.do?cno=${ cno }&page=${page}&key=${key}&keyword=${keyword}` , option )
        .then( r => r.json() )
        .then( response => {
            // 4. 요청 결과 응답 자료 확인
            console.log( response );
            // 5. html를 출력할 구역 dom 가져오기
            const tbody = document.querySelector('tbody')
            // 6. 출력할 html를 저장하는 변수 선언
            let html = ``
            // 7. 응답 자료를 반복문 이용하여 하나씩 순회해서 html 누적으로 더해주기
            // + 응답자료의 게시물 리스트를 추출 
            // response : {data : [], page: , totalpage: ... }
            let boardList = response.data;
            boardList.forEach( board =>{
                html += `<tr>
                            <td> ${ board.bno } </td>
                            <td> <a href = "/board/view?bno=${board.bno}">${ board.btitle }</a> </td>
                            <td> ${ board.mid } </td>
                            <td> ${ board.bview } </td>
                            <td> ${ board.cdate } </td>
                        </tr>`
            }) // f end
            // 8. 반복문 종료후 html 변수에 누적된 <tr> 출력하기
            tbody.innerHTML = html;

            // 9.게시물 출력 후 페이징버튼 생성 함수 호출
            printPageNation(response, cno, key, keyword);
        })
        .catch( e => { console.log( e ); } )
} // f end
findAll(); // JS가 실행될 때 함수 실행

// 2. 페이징 버튼 생성하는 함수 
const printPageNation = (response, cno, key, keyword) => {

    let page = response.page; //현재페이지
    let totalpage = response.totalpagel //전체페이지 
    let startbtn = response.startbtn; //현재 페이지의 페이징 버튼 시작번호 
    let endbtn = response.endbtn; // 현재 페이지의 페이징 버튼 끝번호

    // 1. 어디에
    const pagebox = document.querySelector('.pagebox')

    // 2. 무엇을 
    let html = ``;
    
    // 이전 버튼, 현재페이지 -1 페이지로 이동
    // 만약에 -1했을 때 0이면 1페이지로 고정
    html += `<li class="page-item"><a class="page-link" href="/board?cno=${cno}&page=${page-1 <= 1 ? 1 : page}&key=${key}&keyword=${keyword}">이전</a></li>`;

    // 페이징 버튼 
    for (let i = startbtn ; i <= endbtn ; i++ ){
        // 만약에 현재 페이지와 버튼번호가 같다면 .active라는 부트스트랩 클래스 부여
        html += ` <li class="page-item"><a class="page-link ${page == i ? 'active' : '' }" href="/board?con=${cno}&page=${i}">${i}&key=${key}&keyword=${keyword}</a></li>`
    };
    
    // 다음 버튼, 현재페이지 +1 페이지로 이동
    // 만약에 +1 했을 때 전체페이지수보다 크면 전체페이지로 고정
    html += `<li class="page-item"><a class="page-link" href="/board?cno=${cno}&page=${page+1 > totalpage ? totalpage : page + 1}&key=${key}&keyword=${keyword}">다음</a></li>`;
   

    // 3. 출력
    pagebox.innerHTML = html;
}

// 3. 검색 버튼 함수
const onSearch = () => {
    // 1. 선택한 검색필드와 입력받은 검색어 가져오기
    const key = document.querySelector('.key').value;
    const keyword = document.querySelector('.keyword').value;
    
    // 2. 현재 카테고리 번호를 URL에서 가져오기
    // 검색기능 실행시 현재 카티고리를 유지하기 위해! 
    const cno = new URL(location.href).searchParams.get('cno'); 
     
    // 3. 입력받은 검색필드와 입력받은 검색어로 이동한다.
    // cno는 유지, 검색후 결과는 1페이지 설정
    location.href = `board?con=${cno}&page=1$key=${key}&keyword=${keyword}`
}