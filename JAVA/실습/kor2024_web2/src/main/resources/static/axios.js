// 1.비동기 함수
const test1 = () =>{
    console.log('test1');

    const response = axios.get('/students/list')
    console.log(response.data);

    console.log('test2');

    // 실행순서 : 첫번째콘솔 ->두번째콘솔 -> 세번쨰 콘솔
    // 즉 JS흐름이 AXIOS를 이용하여 요청을 보내고 응답을 기다리지 않고 두번째 콘솔을 출력했으므로 undefined
}

test1()

// 2. 동기 함수
const test2 = async () => {
    console.log('(2)test1')

    const response = await axios.get('/students/list')
    console.log(response.data);

    console.log('(2)test2');

    // 실행순서 : 첫번째콘솔 ->두번째콘솔 -> 세번쨰 콘솔
    // 즉 JS흐름이 AXIOS를 이용하여 요청을 보내고 응답을 올때까지 기다린다. 응답이 오면 다음 코드를 실행한다.
}

test2()


// 3. 학생 점수 등록 버튼 클릭시 실행되는 함수
const onSave = async () => {

    //1 .입력받은 내용 가져오기
    const name = document.querySelector('.name').value;
    const kor = document.querySelector('.kor').value;
    const math = document.querySelector('.math').value;

    // 2. 객체화
    // const obj = {
    //     name : name,
    //     kor : kor,
    //     math : math
    // };
    // JS에서는 객체 속성명과 입변수명이 같다면 속성명 생략 가능
    const obj = {name, kor, math};

    // 선택1) fetch
    // const option = {
    //     method : 'POST',
    //     headers : {'Content-Type' : 'application/json'},
    //     body : JSON.stringify(obj)
    // }

    // fetch('/stydents', option)
    //     .then(response => response.json())
    //     .then(data => {console.log(data)})
    //     .catch(error => {console.log(error)})

    // 선택2 ) axios
    const response = await axios.post('/students/save', obj)
    console.log(response.data)
    if(response.data == 1 ){// 글쓰기 성공이면
        alert('글쓰기 성공');
        onFindAll();// 새로고침
    } else {
        alert('글쓰기 실패');
    }
}

// 4. 학생 점수 전체 조회
const onFindAll = async () => {
    // 1. axios를 이용한 spring controller 매핑
    const response = await axios.get('/students/list')
    // 2. 응답 본문 꺼내기
    const data = response.data;
    // 3. 반복문을 이용하여 html 출력
    const tbody = document.querySelector('tbody');
    let html = '';

    data.forEach( (student) => {
        html += `
            <tr>
                <td>${student.name}</td>
                <td>${student.kor}</td>
                <td>${student.math}</td>
            </tr>
        `
    })

    tbody.innerHTML = html;
}

onFindAll();