// const btn = document.getElementById("button");
// btn.addEventListener("click", (e) => {
//     console.log(e);
// });

const input  = document.getElementById("inputTag");
const inputTest = document.getElementById("test");
const spanLength = document.getElementById("spanLength");
const isValidLength = (legnth) => legnth < 10  ? "black" : "red";
const isValidLengthSize = (lenth) => length >= 4 && lenth <= 12 ? true : "글자수를 정해주세요";
const isValidSign = (length) => length.include("!", "@", "#") ? true : "특수문자를 넣어야합니다.";
const isValidCase = (length) => length.include("it") ? true : "it가 꼭 들어가야합니다."

// inputTag.addEventListener("input", (e) => {
//     // if(e.target.value.length < 10) {
//     //     spanLength.style.color = "black"
//     // } else {
//     //     spanLength.style.color = "red"
//     // }
    
//     // spanLength.style.color =  isValidLength(e.target.value.length);
//     // spanLength.innerText = e.target.value.length;
   
   
//     const value = e.target.value;
//     const length = e.target.value.length;

//     if(length < 4 || length > 12 ){
//         span.innerText = "글자 수를 수정해주세요"
//     } else if(!["!", "@", "#"].some((v) => value.includes(v))){
//         span.innerText = "특수문자를 넣어야합니다."
//     } else if(!value.include("it")){
//         span.innerText = "it가 꼭 들어가야합니다."
//     } else {
//         span.innerText = "통과";
//     }

// });

inputTest.addEventListener("input", (e) => {
    e.target.value = e.target.value.slice(0,10); // slice 문자열을 자르는 함수

});


// html에 span태그를 만들어서 input에 글자갯수를 나타내도록하기

// 0~9 글자 검은색 10글자 이상 span 태그가 빨간색으로 바뀌기



// 입력한 갯수가 4~12사이여야되되고 => false면 글자수를 수정해주세요
// length >= 4 && lenth <= 12 
// 입력한 내용이 !@# 하나 포함해야 하고 => false면 특특수문자를 넣어야합니다.
// 입력한 내용이 소문자 it가 들어가야 하고=> false면 it가 꼭 들어가야합니다.

// 위 내용이 충족되면 span에 통과

// id(test) input에 10글자 10이하까지만 들어가도록 하기

const check = document.getElementById("check");

check.addEventListener('input', (e) => {
    console.log(e.target.checked);
});