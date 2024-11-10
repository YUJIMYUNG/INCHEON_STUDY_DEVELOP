// 버튼이 💛 -> 


const brokenHeart = () => {
   const heart = document.querySelector(".heart");
   heart.innerText  = heart.innerText == "💔" ? "💛" : "💔";
}