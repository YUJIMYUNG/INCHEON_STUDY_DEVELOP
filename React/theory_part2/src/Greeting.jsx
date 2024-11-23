const Greeting = (props) => {
    return (
        <div>
            <span>{props.name} 님 안녕하세요.</span>
            <span>나이가 {props.age} 이시군요!</span>
            <span>{props.vip ? "vip" : "일반"} 회원 환영합니다.</span>
        </div>
    );
};

export default Greeting;