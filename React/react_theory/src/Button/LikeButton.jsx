// LikeButton.jsx
const LikeButton = () => {

    const youtuber = "코리아it";

    const hello = (guest) => `${guest || "guest"}님 환영합니다!`;

    return 
        <div>
            <button>{hello("백종원")}</button>
            <button>{youtuber}좋아요 ! </button>
            <button>{youtuber}좋아요 ! </button>
            <button>{ 5> 3 ? "손흥민 " : "김민재"}</button>
        </div>
};

export default LikeButton;