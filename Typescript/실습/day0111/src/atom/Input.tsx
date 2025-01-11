import React from 'react';
type InputProps = {
    placeholder : string;
    change : (msg:React.ChangeEvent<HTMLInputElement>) => void;
}

const Input = ({placeholder, change} : InputProps) => {
    return (
        <div>
            <input style={{border:"none",
                                width:"100%",
                                outline:"none"
            }} 
            type="text"
            placeholder={placeholder}
            onChange={change}/>
        </div>
    );
};

export default Input;