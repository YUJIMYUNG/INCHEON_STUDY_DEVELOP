import React from 'react';

type ButtonProps = {
    content:string
    click:() => void;
}

const Button = ({content, click} :ButtonProps) => {
    return (
        <div>
            <button onClick={click} style={{backgroundColor:"#98eccd", border:"none", width:"50px", height:"50px", color:"white"}}>{content}</button>
        </div>
    );
};

export default Button;