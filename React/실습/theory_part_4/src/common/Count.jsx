import React, { useState } from 'react';

const Count = (props) => {
    const [num, setNum] = useState(props.num);
  
    const up = () => {
      setNum((v) => {
        return v + 1;
      });
    };
  
    const reset = () => {
      setNum((v) => {
        return props.num;
      });
    };
  
    return (
      <>
        <span className="p-2 border-black ">{num}</span>
        <button onClick={up} className="p-2 border-black">
          plus
        </button>
        <button onClick={reset} className="p-2 border-black">
          reset
        </button>
      </>
    );
  };

export default Count;