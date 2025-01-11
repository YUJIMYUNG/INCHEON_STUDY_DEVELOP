import React, { useState } from 'react';
import CheckBox from '../atom/CheckBox';
import Text from '../atom/Text';
import Label from '../atom/Label';
import { FaRegTrashCan } from "react-icons/fa6";

type TodoProps = {
    label:string
}

const CheckSection = ({label} : TodoProps) => {

    const [isChecked, setIsChecked] = useState(false);

    const handleCheck = () => {
        setIsChecked(!isChecked);
    }

    return (
        <li style={{display:'flex', justifyContent:"space-between"
        }}>
            <CheckBox isChecked={isChecked} onChange={handleCheck}/>
            <Label label={label} isCheked={isChecked}/>
            <FaRegTrashCan />
        </li>
    );
};

export default CheckSection;