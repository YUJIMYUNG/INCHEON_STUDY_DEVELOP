import React, { useState } from 'react';
import Coffee from './Coffee';

const SelectedCoffee = () => {
    const [buttons, setButtons] = useState([false, false, false, false]);

    const change = (x) => {
        setButtons((prev) => {
            const newArr = prev.map((v, i) => i === x);
            return newArr;
        });
    };

    return (
        <div>
            <Coffee text={"전체"} change={()=>change(0)} isSelected={buttons[0]}/>
            <Coffee text={"커피"} change={()=>change(1)} isSelected={buttons[1]}/>
            <Coffee text={"더치커피"} change={()=>change(2)} isSelected={buttons[2]}/>
            <Coffee text={"논커피 라떼"} change={()=>change(3)} isSelected={buttons[3]}/>
            
        </div>
    );
};

export default SelectedCoffee;