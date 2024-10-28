// 유저에게 비밀번호 확인을 입력 받고
const password = prompt("비밀번호 확인");

// // 1. 문자 길이가 4~12 글자 사이가 아니면 -> alert
// // 네글자 미만이면 비밀번호가 짧습니다
// // 열두글자 초과하면 비밀번호가 깁니다.
// if (password.length() > 13) {
//   alert("비밀번호가 길어요");
// } else if (password.length() <= 4) {
//   alert("비밀번호가 짧아요");
// } else if (
//   !password.includes("!") ||
//   !password.includes("#") ||
//   !password.includes("@")
// ) {
//   alert("특수문자가 만드시 들어가야합니다."); // 2. 특수문자 !, #, @ 셋 중에 하나라도 포함이 안되면 특수문자가 반드시 들어가야합니다!
// } else if (!password.endsWith(1) == "z") {
//   // 3. 마지막 글자가 z 끝나지 않으면 마지막 글자는 z로 끝나야합니다!
//   alert("마지막 글자는 z로 끝나야합니다.");
// } else if (!password.lastIndexOf(1) == "z") {
//   // 4. 위 케이스 통과하면
//   // 올바르게 비밀번호 설정하였습니다!
//   alert("마지막 글자는 z로 끝나야합니다.");
// }

const alertMsg = {
  pwShort: "비밀번호가 짧습니다.",
  pwLong: "비밀번호가 깁니다.",
  pwNotIncludeSpecial: "특수문자가 반드시 들어가야 합니다!",
  pwNotEndZ: "마지막 글자는 z로 끝나야합니다!",
  pwSuccess: "올바르게 비밀번호를 설정하였습니다.",
};

const isLowerThan4 = password.length < 4;
const isLongThan12 = password.length > 12;
const hasSpecial =
  !password.includes("!") || !password.includes("#") || !password.includes("@");
const isEndZ = !password.endsWith("z");

if (isLowerThan4) {
  alert(alertMsg.pwShort);
} else if (isLongThan12) {
  alert(alertMsg.pwLong);
} else if (hasSpecial) {
  alert(alertMsg.pwNotIncludeSpecial);
} else if (isEndZ) {
  alert(alertMsg.pwNotEndZ);
} else {
  alert(alertMsg.pwSuccess);
}
