console.log('api2.js open')
//GolocationAPI -> 접속한 위치 정보 가져오는 api

// 1. 간단한 지도 띄우기
// var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
// var options = { //지도를 생성할 때 필요한 기본 옵션
// 	center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
// 	level: 3 //지도의 레벨(확대, 축소 정도)
// };

// var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴




// 2. 클릭한 위치에 마커 표기하기
// var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
//     mapOption = { 
//         center: new kakao.maps.LatLng(37.492129708891085, 126.72363542231002), // 지도의 중심좌표
//         level: 3 // 지도의 확대 레벨
//     };

// var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// // 지도를 클릭한 위치에 표출할 마커입니다
// var marker = new kakao.maps.Marker({ 
//     // 지도 중심좌표에 마커를 생성합니다 
//     position: map.getCenter() 
// }); 
// // 지도에 마커를 표시합니다
// marker.setMap(map);

// // 지도에 클릭 이벤트를 등록합니다
// // 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
// kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
    
//     // 클릭한 위도, 경도 정보를 가져옵니다 
//     var latlng = mouseEvent.latLng; 
    
//     // 마커 위치를 클릭한 위치로 옮깁니다
//     marker.setPosition(latlng);
    
//     var message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
//         // ++ 추후에 사용자가 클릭한 위치의 위도와 경도를 DB에 저장해서 활용
//     message += '경도는 ' + latlng.getLng() + ' 입니다';
    
//     // var resultDiv = document.getElementById('clickLatlng'); 
//     // resultDiv.innerHTML = message;
    
// });




// 3. 마커에 클릭 이벤트 등록하기
// var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
//     mapOption = { 
//         center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
//         level: 3 // 지도의 확대 레벨
//     };

// var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
  
// // 마커를 표시할 위치입니다 
// var position =  new kakao.maps.LatLng(33.450701, 126.570667);

// // 마커를 생성합니다
// var marker = new kakao.maps.Marker({
//   position: position,
//   clickable: true // 마커를 클릭했을 때 지도의 클릭 이벤트가 발생하지 않도록 설정합니다
// });

// // 아래 코드는 위의 마커를 생성하는 코드에서 clickable: true 와 같이
// // 마커를 클릭했을 때 지도의 클릭 이벤트가 발생하지 않도록 설정합니다
// // marker.setClickable(true);

// // 마커를 지도에 표시합니다.
// marker.setMap(map);

// // 마커를 클릭했을 때 마커 위에 표시할 인포윈도우를 생성합니다
// var iwContent = '<div style="padding:5px;">Hello World!</div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
//     iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다

// // 인포윈도우를 생성합니다
// var infowindow = new kakao.maps.InfoWindow({
//     content : iwContent,
//     removable : iwRemoveable
// });

// // 마커에 클릭이벤트를 등록합니다
// kakao.maps.event.addListener(marker, 'click', function() {
//     alert("마커 클릭 이벤트")
//       // 마커 위에 인포윈도우를 표시합니다
//       //infowindow.open(map, marker);  
// });





// 4. 여러개 마커 표시하기
    // 1). 지도를 출력할 dom객체를 가져오기
// var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
//     // 2). 지도를 출력하기 전에 옵션 정보를 설정한다. (지도의 중심 좌표)
//     mapOption = { 
//         center: new kakao.maps.LatLng(37.492129708891085, 126.72363542231002), // 지도의 중심좌표
//         level: 3 // 지도의 확대 레벨
//     };

//     // 3) 지도 객체를 생성한다.
// var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
 
// // 마커를 표시할 위치와 title 객체 배열입니다 
//     // 4) 지도 객체에 출력할 마크업들의 정보(마크업제목, 마크업 위경도)
//     // 데이터베이스에 저장된 위도/경도 여러개를 여러마커로 표시할 수 있다.
// var positions = [
//     {
//         title: '카카오', 
//         latlng: new kakao.maps.LatLng(33.450705, 126.570677)
//     },
//     {
//         title: '생태연못', 
//         latlng: new kakao.maps.LatLng(33.450936, 126.569477)
//     },
//     {
//         title: '텃밭', 
//         latlng: new kakao.maps.LatLng(33.450879, 126.569940)
//     },
//     {
//         title: '근린공원',
//         latlng: new kakao.maps.LatLng(33.451393, 126.570738)
//     },
//     {
//         title: '학원',
//         latlng: new kakao.maps.LatLng(37.492129708891085, 126.72363542231002)
//     }
// ];

// // 마커 이미지의 이미지 주소입니다
// var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
    
// for (var i = 0; i < positions.length; i ++) {
    
//     // 마커 이미지의 이미지 크기 입니다
//     var imageSize = new kakao.maps.Size(24, 35); 
    
//     // 마커 이미지를 생성합니다    
//     var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
    
//     // 마커를 생성합니다
//     var marker = new kakao.maps.Marker({
//         map: map, // 마커를 표시할 지도
//         position: positions[i].latlng, // 마커를 표시할 위치
//         title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
//         image : markerImage // 마커 이미지 
//     });
// }





// 5. 마커 클러스터 사용하기
//클러스터 사용지 html js src에 &libraries=clusterer"추가

// 1). 지도의 중심좌표와 지도확대 레벨 초기설정하고 지도를 표시할 dom을 가져오는 코드
var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
    center : new kakao.maps.LatLng(37.492129708891085, 126.72363542231002), // 지도의 중심좌표 
    level : 10 // 지도의 확대 레벨 
});

// 2). 마커 클러스터러를 생성합니다 
// 클러스터란 마커 주변에 마커들이 있을 때 집합 아이콘으로 만들어주는 것
var clusterer = new kakao.maps.MarkerClusterer({
    map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
    averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
    minLevel: 10 // 클러스터 할 최소 지도 레벨 
});

// 공식문서) 데이터를 가져오기 위해 jQuery를 사용합니다
// 데이터를 가져와 마커를 생성하고 클러스터러 객체에 넘겨줍니다
// var markers = $(data.positions).map(function(i, position) {
//     return new kakao.maps.Marker({
//         position : new kakao.maps.LatLng(position.lat, position.lng)
//     });
// });

// $.get("/download/web/data/chicken.json", function(data) {
//     // 데이터에서 좌표 값을 가지고 마커를 표시합니다
//     // 마커 클러스터러로 관리할 마커 객체는 생성할 때 지도 객체를 설정하지 않습니다

//     // 클러스터러에 마커들을 추가합니다
//     clusterer.addMarkers(markers);
// });


// 3). fetch를 이용한 데이터 가져오기
// 공공데이터 자료 요청(인천시 동구 약국 현황)
const url = 'https://api.odcloud.kr/api/15051492/v1/uddi:852bbc11-63ed-493e-ab09-caaaf54fd144?page=1&perPage=35&serviceKey=XEuSGTDwYuZg1CQRYQxK%2FMsSVfbFnOLt%2BD85%2BDYiNuEetwdbGAWewQYWEM7mhh7paJserwl89lGEm6rUJV3oiQ%3D%3D';
fetch(url)
    .then(r =>r.json())
    .then(d => {
        console.log(d)
        // 4). 응답 받은 자료로 마커 만들기

        // // 1. for문
        // let markers = [];
        // for (let index = 0; index < d.data.length; index++) {
        //     // 2. 응답받은 자료에서 data에 약국정보가 있음
        //     let data = d.data[index];

        //     // 3. 마커 생성
        //     let marker = new kakao.maps.Marker({ position : new kakao.maps.LatLng(data.위도, data.경도)})

        //     // 4. 생성한 마커를 마커목록/리스트에 넣어준다
        //     markers.push(marker);
            
        // } // for end

        // // 5. 마커목록 을 클러스트에 추가
        // clusterer.addMarkers(markers);


        // // 2. foreach문
        // let markers = [];
        // d.data.forEach ( data => {
        //     // 마커 생성
        //     let marker = new kakao.maps.Marker({ position : new kakao.maps.LatLng(data.위도, data.경도)})
        //     // 생성한 마커를 마커목록에 넣어준다.
        //     markers.push(marker);
        // })//foreach end 
        // clusterer.addMarkers(markers);


        // 3. map
        let markers = d.data.map( data => {
             // 마커 생성
            let marker = new kakao.maps.Marker({ position : new kakao.maps.LatLng(data.위도, data.경도)});

            kakao.maps.event.addListener(marker, 'click', () => {
                //alert(`${data.약국명} 을 클릭함`)

                // 부트스트랩의 오픈캔버스 활용해보기
                // 클릭한 마커의 약국 정보를 사이드바(div)에 값을 대입한다.
                 document.querySelector('.drugstoreName').innerHTML = data.약국명;
                 document.querySelector('.drugstorePhonNum').innerHTML = data.전화번호;
                 document.querySelector('.drugstoreAddress').innerHTML = data.소재지도로명주소;

                 // 부트스트랩에 오픈캔버스 실행 버튼 클릭 이벤트
                 document.querySelector('.sidbar-btn').click(); //js에서 특정한 버튼 강제로 클릭하기
                
                
         
                
                
            })


            // 일반for문, foreach문과 다르게 map은 return하면 자동으로 새로운 배열로 대입된다.
            // 반복문에 return 된 값은 Markers 배열에 대입된다. 즉 Push가 생략됨
            return marker;

        })
        clusterer.addMarkers(markers);




    })
    .catch(e => {
        console.log(e)
        
    })

