import React from 'react';

const Button = ({contents, style}) => {
    return (
        <button style={{fontWeight:"blod", ...style}}>{contents}</button>
    );
};

export default Button;