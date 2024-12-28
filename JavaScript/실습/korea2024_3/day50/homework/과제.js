// 1. 할일 목록(배열) 전역변수 선언, 샘플 데이터 포함
let todoList = [
    {no : 1, content : "1교시 수업 듣기", state : false},
    {no : 2, content : "여행 준비하기", state : true},
]

// 2. 할 일 코드(Pk역할) 부여하기 위한 식별번호, auto_increment
let autoNum = 3;

// 3. 등록함수 정의, 사용처 : 등록버튼 클릭했을 때 매개변수 : X  반환값 : X  ;
function add(){
    const conInput = document.querySelector('.conInput');
    const todoContent = conInput.value;
    const todo = {
        no : autoNum,
        content : todoContent,
        state : false
    }
    todoList.push( todo );
    autoNum ++;
    alert("할 일이 등록 되었습니다.");
    conInput.value = ``;
    console.log(todoList);
    print();
    return;
}

// 4. 출력함수 정의, 사용처 : js가 실행 될 때, 등록/수정/삭제 했을 때 매개변수 : X   반환값 : X  ;
print();
function print(){
    const todoBottom = document.querySelector('.todoBottom');
    let HTML = ``;
    // 1. 할일 목록(배열) 내 모든 요소 하나씩 html문자열 만들기
    for(let i = 0 ; i < todoList.length ; i++){
        const todo = todoList[i];
        HTML += `
            <div class="conBox ${todo.state ? 'success' : '' }">
                <div class="cont">${todo.content}</div>
                <div class="conBtns">
                    <button onClick="reset(${todo.no})" class="updateBtn">수정</button>
                    <button onClick="del(${todo.no})" class="deleteBtn">삭제</button>
                </div>
            </div>`;
    }
    todoBottom.innerHTML = HTML;
}

// 5. 수정함수 정의, 사용처 : 수정 버튼을 클릭했을 때 매개변수 : 수정할 할 일 코드 반환값: X   ;
function reset(autoNum){
    // 배열 내 수정할 할일 코드 객체 찾기
    for(let i = 0 ;  i < todoList.length ; i++){
        if(todoList[i].no == autoNum){
            let todoState = todoList[i].state;  // 할일 상태 꺼내고
            todoList[i].state = !todoState; // 할일 상태의 반대를 저장함
            break; //수정했으면 for end 
        }
    }
    print();
    return;
}

// 6. 삭제함수 정의, 사용처 : 삭제 버튼 클릭했을 때 매개변수 : 삭제 할 일 코드 반환값: X   ;
function del(autoNum){
    let HTML = ``;
     // 배열 내 삭제할 할일 코드 객체 찾기
    for(let i = 0 ; i < todoList.length ; i++){
        if(todoList[i].no == autoNum){
            todoList.splice(i, 1); //splice : 배열 요소 삭제
            break;//삭제 했다면 for end
        }
    }
    print();
    return;
}