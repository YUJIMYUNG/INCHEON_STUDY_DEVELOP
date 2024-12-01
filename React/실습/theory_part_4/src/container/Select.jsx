import StatusButton from '../common/StatusButton';
import { useState } from "react";

const Select = () => {
    const [buttons, setButtons] = useState([false, false, false]);

    const change = (x) => {
        setButtons((prev) => {
            const newArr = prev.map((v, i) => i === x);
            return newArr;
        });
    };

    return (
        <div>
            <StatusButton text={"OK"} change={() => change(0)} isSelected={buttons[0]} />
            <StatusButton text={"NG"} change={() => change(1)} isSelected={buttons[1]} />
            <StatusButton text={"미해당"} change={() => change(2)} isSelected={buttons[2]} />
        </div>
    );
};

export default Select;