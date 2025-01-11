import React from 'react';
type CheckBoxProps  = {
    isChecked : boolean;
    onChange : () => void;
}

const CheckBox = ({isChecked, onChange} :CheckBoxProps) => {
    return (
        <div>
            <input type="checkbox" checked={isChecked} onChange={onChange}/>
        </div>
    );
};

export default CheckBox;