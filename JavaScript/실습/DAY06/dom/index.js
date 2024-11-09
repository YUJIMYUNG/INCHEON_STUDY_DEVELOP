//JS로 HTML 다루기!

//document[html]
//1. JS로 태그 만들기
const btn = document.createElement("button");
btn.innerText = "메론빵";
// btn.style.backgroundColor = "pink";
// btn.style.border = "1px solid pink";
// btn.style.cssText = "color:pink; border-radius:8px";
document.body.appendChild(btn);

// 1.
// div태그 만들고
// 안에는 좋아하는 커피 넣고
// 바디태그에 달아서 넣기
// const divTag = document.createElement("div");
// divTag.innerText = "아메리카노";
// document.body.appendChild(divTag);

// // 2.
// // 유저에게 원하는 태그와 내용을 한번에 입력받고
// // 바디태그에 나타내기!
// // button 라떼
// const input = prompt("태그와 내용 입력");
// const arr = input.split(" ");
// const tag = document.createElement(arr[0]);
// tag.innerText = arr[1];
// document.body.appendChild(tag);
