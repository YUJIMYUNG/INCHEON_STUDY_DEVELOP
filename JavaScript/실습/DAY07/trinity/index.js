
// js로 html, css 만들기
// css : 스타일 +  구조 파일
// js : 데이터와 연관된 구조 / 퍼블리싱 + 이벤트(클릭하기, 키보드 입력, 터치, 스크롤)

import { data } from "./data.js";
import { makeRoomCard } from "./func.js";

// 첫번째 문법
const container = document.querySelector(".container");


// appendChild vs insertAdjactHTMl
// 두번째 문법
// container.insertAdjacentHTML('beforeend', makeRoomCard(data[0].imgUrlList[0], data[0].priceTitle, data[0].roomDesc));
// container.insertAdjacentHTML('beforeend', makeRoomCard(data[1].imgUrlList[0], data[1].priceTitle, data[1].roomDesc));
// container.insertAdjacentHTML('beforeend', makeRoomCard(data[2].imgUrlList[0], data[2].priceTitle, data[2].roomDesc));
// container.insertAdjacentHTML('beforeend', makeRoomCard(data[3].imgUrlList[0], data[3].priceTitle, data[3].roomDesc));


data.forEach((v) => container.insertAdjacentHTML('beforeend', makeRoomCard(v.imgUrlList[0], v.priceTitle, v.roomDesc)));
