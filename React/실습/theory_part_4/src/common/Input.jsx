import React, { useState } from 'react';

const Input = () => {
    const [num, setNum] = useState(0);
    const [isOver10, setIsOver10] = useState(false);
  
    //10글자 넘어가면 숫자가 빨간색으로
    const change = (e) => {
      setNum((v) => {
        return e.target.value.length;
      });
      setIsOver10((v) => {
        return e.target.value.length > 10;
      });
    };
  
    return (
      <>
        <input onChange={(e) => change(e)} type="text" />
        <span style={{ color: isOver10 ? "red" : "black" }}>{num}</span>
      </>
    );
  };
export default Input;