// const name = prompt("당신의 이름이 뭔가요?");
// console.log(name);

// const age = prompt("당신의 나이는 몇살인가요?");
// console.log(age);

// const mbti = prompt("당신의 mbti가 뭔가요?");
// console.log(mbti);

//유저에게 오늘의 요일을 물어보고
//유저에게 오늘 할 일을 물어보고
//유저에게 오늘의 기분 물어본 후에
//당신 오늘 ~요일에 할일은 ~~이시군요! 기분이 ~~하시군요!

const dayOfTheWeek = prompt("오늘 무슨요일인가요?");
const toDo = prompt("오늘 할 일은 무엇인가요?");
const mood = prompt("오늘 기분은 어떤가요?");

console.log(
  `당신은 오늘 ${dayOfTheWeek}요일에 할 일은${toDo}이시군요~~! 기분이 ${mood}하시군요~~!`
);
