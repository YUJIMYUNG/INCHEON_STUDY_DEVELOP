// 1. 이메일 주소를 입력받고, 도메인을 돌려주는 함수 만들기
// ex) itkorea@naver.com -> naver
// hint) split 함수 활용

const inputEmail = prompt("이메일 주소를 입력해주면 도메인을 돌려줄게");

const getDomain = (email) => {
  const arr = email.split("@"); // [itkorea, naver.com]
  const arr1 = arr[1].split("."); // [naver, com];
  return arr1[0];
};
console.log(getDomain(inputEmail));

// 2. 영어 신문기사를 입력 받고, 모두 대문자로 바꾸는 함수 만들기
const news = prompt("신문기사를 입력해보세요.");

// const newsUpperCase = (text) => {
//   return text.toUppercase();
// };

// console.log(newsUpperCase(news));

// 3. 영어뉴스 기사를 가져오고 단어별로 나누고, 첫번째, 두번째, 세번째 단어들을 돌려주기
const getWord = prompt("신문 기사를 입력하면 단어 리턴");
const wordReturn = (news) => {
  const newsWord = news.split(" ");
  return newsWord[0], newsWord[1], newsWord[2];
};

console.log(wordReturn());
