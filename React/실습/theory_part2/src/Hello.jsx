import React from 'react';

const Hello = (props) => {
    return (
        <div>
            <span>{props.data.name} 님 안녕하세요.</span>
            <span>나이가 {props.data.age} 이시군요!</span>
            <span>{props.data.vip ? "vip" : "일반"} 회원 환영합니다.</span>
        </div>
    );
};

export default Hello;