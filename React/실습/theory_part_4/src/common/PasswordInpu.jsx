import React from 'react';

const PasswordInpu = ({text, change}) => {
    return (
        <div className='p-3 flex gap-1 border border-black bg-slate-200'>
        <span>비밀번호</span>
        <input type="text" onChange={(e)=> change1(e)}/>
    </div>
    );
};

export default PasswordInpu;