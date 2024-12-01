import React from 'react';

const Icon = (props) => {
    return (
        <div className='flex flex-col items-center'>
            <span>
                {props.icon}
            </span>
            <span>
                {props.title}
            </span>
        </div>
    );
};

export default Icon;