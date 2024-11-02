// 1. [5, 13, 25, 31, 49를 모두 숫자 10 더해서 콘솔로 나타내기!]

const array = [5, 13, 25, 31, 49];

console.log(array.map((a) => a + 10));

// 2. [5, 13, 25, 31, 49]를 홀수면 두배 짝수면 -10을 해서 콘솔로 나타내기

console.log(array.map((a) => (a % 2 ? a * 2 : a - 10)));

// 3. ["kiwi", "apple", "orange", "pineapple"]
// apple 포함하면 대문자로 바꾸고 아니면 문자 길이로 바꾸기!

const arr2 = ["kiwi", "apple", "orange", "pineapple"];
arr2.map((a) => (a.includes("apple") ? a.toUpperCase() : a.length));
