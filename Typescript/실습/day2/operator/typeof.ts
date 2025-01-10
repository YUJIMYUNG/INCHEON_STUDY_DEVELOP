const laptop = {cpu:"라이젠", ram:32, gpu :"엔비디아"};
type Laptop = typeof laptop;
const youLaptopL:Laptop = {
    cpu : "인텔",
    ram : 16,
    gpu: "엔비디아" 
}

// 옷입기(룩)
// 변수 상의, 하의, 악세사리, 코스메틱[화장품]
// 타입오브 연산자 사용해서 타입추출하기
const lookbook = {top:"반팔", bottom:"청바지", acc:"귀걸이", comsmatic:["눈썹", "아이세도우", "마스카라"]};
type Lookbook = typeof lookbook;
const yourLook:Lookbook = {
    top:"셔츠",
    bottom:"치마",
    acc:"목걸이",
    comsmatic:["파운데이션", "향수"]

}