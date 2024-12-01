import React from 'react';

const Coffee = ({change, text, isSelected}) => {
    return (
        <button
            onClick={change}
            className='p-3 border border-black font-bold'
            style={{backgroundColor : isSelected ? "gray" : "white", color : isSelected ? "white" : "black"}}>
            {text}
        </button>
    );
};

export default Coffee;