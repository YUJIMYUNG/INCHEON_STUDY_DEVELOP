const user = !!prompt("유저의 이름 입력") || "Guest";
alert(`${user}님 환영합니다.`);

// 유저에게 비밀번호 입력 : 1234
/// 1234를 입력하면 알럿으로 로그인 축하!
// 그 외에는 아무것도 안일어남

const question = prompt("비밀번호를 입력하세요");
const result = question == "1234";
result && alert("로그인 축하");
//const userPassword = Number(question) === 1234 ? alert(`로그인 축하!`) : null;
