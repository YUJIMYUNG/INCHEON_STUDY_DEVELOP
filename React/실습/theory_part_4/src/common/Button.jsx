import React from 'react';

const Button = ({num, coffeeName}) => {
    
    //props로 커피 이름을 받으면
    //버튼 안의 컨텐츠 커피 이름이 나오고
    //클릭하면 alert ~~커피 주문하셨습ㄴ디ㅏ!

    const coffeeOrder = (x) => {
        alert(`${x}개 ${coffeeName} 커피 주문 하셨습니다~`);
    }
    
    const hello = () => {
        alert("안녕!")
    }

    return (
        <div>
            {/* <button onClick={()=>hello()} className='p-3 bg-green-300  border-r-2'>버튼</button> */}
            <button className='p-3 bg-green-300  border-r-2' onClick={()=>coffeeOrder(num)} >{coffeeName}</button>
        </div>
    );
};

export default Button;