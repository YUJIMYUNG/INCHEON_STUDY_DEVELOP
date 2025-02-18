console.log('api1.js open');

// 1. 부평구 인구현황 요청 함수
const api1 = () => {

    // 1. 요청할 url
    const url = 'https://api.odcloud.kr/api/3044322/v1/uddi:466eee86-a8be-447b-9c8e-802bdbe897d7?page=1&perPage=22&serviceKey='

    // 2. 요청할 API 인증 key
    const serviceKey = 'XEuSGTDwYuZg1CQRYQxK%2FMsSVfbFnOLt%2BD85%2BDYiNuEetwdbGAWewQYWEM7mhh7paJserwl89lGEm6rUJV3oiQ%3D%3D';

    // 3. fetch
    fetch( url + serviceKey) // url과 servicekey를 합친다.
        .then(r => r.json())
        .then(responseData => {
            console.log(responseData)
            
            // (1) 출력할 DOM(HTML)을 가져온다
            const boardTable1 = document.querySelector('.boardTable1');
            
            // (2) 출력할 내용을 저장할 변수 선언 
            let html = '';
            

            // (3) 출력할 자료를 반복문을 이용하여 여러 자료를 html문법으로 표현한다.
            responseData.data.forEach( (obj) => {
                // 객체변수명.속성명 vs 객체변수명['속성명']
                // 객체내 속성값 호출시 주의할점 : 속성명에 특수문자가 있을 경우에는 대괄호 사용
                // console.log(obj['동별']);

                html += `
                    <tr>
                        <td>${obj['동별']}</td>
                        <td>${obj['세대수'].toLocaleString()}</td>
                        <td>${obj['인구수(계)'].toLocaleString()}</td>
                        <td>${obj['인구수(남)'].toLocaleString()}</td>
                        <td>${obj['인구수(여)'].toLocaleString()}</td>
                    </tr>
                `
            }) // foreach end

            boardTable1.innerHTML = html;

        })
        .catch(error => {console.log(error)})
}

api1(); // 함수 실행


const api2 = () => {
    console.log("api2 함수 실행")

    // 1. 입력받은 데이터 가져오기
    const companyInputBox = document.querySelector('.companyInputBox'); console.log(companyInputBox);
    const companyNum = companyInputBox.value; 

    // 2. 요청 자료 만들기
    const data = { "b_no" : [companyNum.replaceAll('-','')] } // 입력받은 사업자번호를 api 구성 방식에 맞게 작성

    // 3. url
    const url = "https://api.odcloud.kr/api/nts-businessman/v1/status?serviceKey=";

    // 4. service key
    const serviceKey = 'nwPZ%2F9Z3sVtcxGNXxOZfOXwnivybRXYmyoIDyvU%2BVDssxywHNMU2tA55Xa8zvHWK0bninVkiuZAA4550BDqIbQ%3D%3D';

    // 5. fetch
    const option = {
        method : 'POST',
        headers : {'Content-Type' : 'application/json'},
        body : JSON.stringify(data)
    }

    fetch( url + serviceKey, option )
        .then(response => response.json())
        .then(responseData => {
            console.log(responseData)

            // 6. 만약에 요청 성공시 응답 자료 활용 
            const resultBox = document.querySelector('.resultBox');
            let html = responseData.data[0].tax_type;
            resultBox.innerHTML = html;


        })
        .catch(error => {console.log(error)})
}


// 3. 부평구 맛집 api
const api3 = () => {
    console.log('api3 함수 실행 ');

    // 1. 요청할 url
    const url = "https://api.odcloud.kr/api/15103411/v1/uddi:0875260e-d807-49b7-85fe-adb00bfa76ce?page=1&perPage=70&serviceKey="
    
    // 2. serviceKey 
    const serviceKey = 'XEuSGTDwYuZg1CQRYQxK%2FMsSVfbFnOLt%2BD85%2BDYiNuEetwdbGAWewQYWEM7mhh7paJserwl89lGEm6rUJV3oiQ%3D%3D';

    // 3. fetch
    fetch( url + serviceKey) // url과 servicekey를 합친다.
        .then(r => r.json())
        .then(responseData => {
            console.log(responseData)
            
            // (1) 출력할 DOM(HTML)을 가져온다
            const boardTable2 = document.querySelector('.boardTable2');
            
            // (2) 출력할 내용을 저장할 변수 선언 
            let html = '';
            

            // (3) 출력할 자료를 반복문을 이용하여 여러 자료를 html문법으로 표현한다.
            responseData.data.forEach( (obj) => {
                // 객체변수명.속성명 vs 객체변수명['속성명']
                // 객체내 속성값 호출시 주의할점 : 속성명에 특수문자가 있을 경우에는 대괄호 사용

                html += `
                    <tr>
                        <td>${obj['연번']}</td>
                        <td>${obj['업 소 명']}</td>
                        <td>${obj['소재지']}</td>
                        <td>${obj['지정메뉴']}</td>
                        <td>${obj['전화번호']}</td>
                        <td>${obj['업태']}</td>
                    </tr>
                `
            }) // foreach end

            boardTable2.innerHTML = html;

        })
        .catch(error => {console.log(error)})

}

api3();

// 4. chrt.js 샘플코드
const api4 = () => {
    const ctx = document.getElementById('myChart');
      
    // 차트 객체 생성
    new Chart(ctx, {
        type: 'line',
        data: { // 차트에 들어갈 자료들
        labels: ['1월', '2월', '3월', '4월', '5월', '6월'], // labels : 가로축 제목들
        datasets: [{ // 여러개의 항목 자료들
            label: '사이다 판매량',  // 범례 제목
            data: [12, 19, 3, 5, 2, 3], // 항목의 값(세로축)
            borderWidth: 1 // 선 굵기
        },
        {
            label: '콜라 판매량',  // 범례 제목
            data: [10, 25, 30,28, 12, 13], // 항목의 값(세로축)
            borderWidth: 1 // 선 굵기
        }]
        },
        options: {
        scales: {
            y: {
            beginAtZero: true
            }
        }
        }
    });

}

api4();

//부평구 남자인구수, 여자인구수 차트 시각화
const api5 = () => {
    // 1. 부평구 인구현황 api url
    
     // 1. 요청할 url
     const url = 'https://api.odcloud.kr/api/3044322/v1/uddi:466eee86-a8be-447b-9c8e-802bdbe897d7?page=1&perPage=22&serviceKey='

     // 2. 요청할 API 인증 key
     const serviceKey = 'XEuSGTDwYuZg1CQRYQxK%2FMsSVfbFnOLt%2BD85%2BDYiNuEetwdbGAWewQYWEM7mhh7paJserwl89lGEm6rUJV3oiQ%3D%3D';
 
     // 3. fetch
     fetch( url + serviceKey) // url과 servicekey를 합친다.
         .then(r => r.json())
         .then(responseData => {
             console.log(responseData)

            // 데이터 준비
            let dongList = [];
            responseData.data.forEach( obj => {
                dongList.push(obj['동별']);
            })

            let menList = [];
            responseData.data.forEach( obj => {
                menList.push(obj['인구수(남)'])
            })

            let womenList = [];
            responseData.data.forEach( obj => {
                womenList.push(obj['인구수(남)'])
            })


            
             // chart를 표현할 dom가져오기
             const myChart2 = document.querySelector(".myChart2");
             
             // 차트 객체 생성
            new Chart(myChart2, {
                type: 'bar',
                data: { // 차트에 들어갈 자료들
                labels: dongList, // 동별
                datasets: [{ // 여러개의 항목 자료들
                    label: '남자 인구수',  // 범례 제목
                    data: menList, // 항목의 값(세로축)
                    borderWidth: 1 // 선 굵기
                },
                {
                    label: '여자 인구수',  // 범례 제목
                    data: womenList, // 항목의 값(세로축)
                    borderWidth: 1 // 선 굵기
                }]
                }
            });

 
         })
         .catch(error => {console.log(error)})

}

api5();