const fruits = ["apple", "banana", "pineapple", "mango", "kiwi"];

const[a, b, c] = fruits; // apple, banana, pineapple
const [a1] = fruits; // apple

const test = ()=>{
    return ["국어", "영어", "수학", "사회", "과학"];
};

const[a2, b2, c2] = test();  // 국영수