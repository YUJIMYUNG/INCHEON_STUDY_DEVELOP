import React, { useState } from 'react';

const Toggle = () => {

    // 상태 변경(state 변경) 
    // const [초기값, 값을 변경하는 함수] = useState(초기값);

    const [fruit, setFruit] = useState("🍓");

    const change = () => {
        setFruit((v)=>{
            return "🍇"
        })
    }

    return (
        <div>
            <button onClick={()=>change()} className='p-s bg-red-300'>{fruit}</button>
            
        </div>
    );
};

export default Toggle;