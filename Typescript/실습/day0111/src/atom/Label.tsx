import React from 'react';
export type LabelProps = {
    label : string
    isCheked: boolean
}

const Label = ({ label, isCheked }: LabelProps) => {
    return (
        <div>
            <label style={{textDecoration: isCheked ? 'line-through' : 'none'}} htmlFor="">{label}</label>
        </div>
    );
};

export default Label;