// skill 함수를 정의하고
// 스킬 발동!!! ~~~스킬 마무리~

// const skill = (skillName) => {
//   console.log("스킬 발동!!!!!!!❤️‍🔥❤️‍🔥❤️‍🔥❤️‍🔥❤️‍🔥❤️‍🔥❤️‍🔥");
//   skillName();
//   console.log("스킬 마무리~~~");
// };

// const ice = () => {
//   console.log("얼음 모으기");
//   console.log("얼음 발사");
// };
// const thunder = () => {
//   console.log("번개 모으기");
//   console.log("번개 발사");
// };
// const fire = () => {
//   console.log("불 모으기");
//   console.log("불 발사");
// };

// //유저에게 어떠한 스킬을 발동시킬까요 (1,2,3)
// //콘솔로 결과값 나타내기

// const prom = prompt(
//   "유저에게 어떠한 스킬을 발동시킬까요 ? 1.얼음, 2.번개, 3. 불"
// );

// if (prom == 1) {
//   skill(ice);
// } else if (prom == 2) {
//   skill(thunder);
// } else if (prom == 3) {
//   skill(fire);
// } else {
//   console.log("그런 스킬 없어");
// }

const triggerSkill = (skill) => {
  console.log("스킬 발동!");
  skill();
  console.log("스킬 마무리!");
};

const elementSkill = (element) => {
  console.log(`${element} 모으기`);
  console.log(`${element} 발사`);
};

const skills = ["💦", "⚡️", "🔥"];
const skillNumber = Number(
  prompt("어떤 스킬을 발동할까요? 0.💦 ,1.⚡️ , 2.🔥")
);
triggerSkill(() => elementSkill(skills[skillNumber]));

// 타코 음식 만들기

// 요리하기 함수 만들기 (요리시작~ 요리 끝!)
const cooking = (tacoIngredient) => {
  console.log("요리시작🍳🍳🍳🍳🍳");
  tacoIngredient();
  console.log("요리끝 🌮🌮🌮🌮");
};

// 타코 만들기 함수 만들기
// 1. 타코 준비 -> 2. 메뉴 넣기 -> 3. 굽기 -> 4. 타코완성

const tacoIngredient = (ingredient) => {
  console.log("타코 준비");
  console.log("메뉴 넣기");
  console.log(`${ingredient}`);
  console.log("굽기");
  console.log("타코 완성");
};

// 유저에게 타코 메뉴를 선택
const ingredients = ["🦐", "🐷", "🍗", "🧀"];
const ingredientSelect = Number(
  prompt("타코 메뉴를 숫자로 입력해주세요. 0.🦐 1.🐷 2.🍗 3.🧀")
);
// 준비된 ~~타코가 나왔습니다!
cooking(() => tacoIngredient(ingredients[ingredientSelect]));
