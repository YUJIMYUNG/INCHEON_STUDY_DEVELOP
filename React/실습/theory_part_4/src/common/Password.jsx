// 두개의 input태그가 있고 서로의 input 내용이 같으면
// 아래 버튼이 일치로 바뀌고 아니면 불일치

import React, { useState } from 'react';

const Password = () => {
    // const [text1, setText1] = useState();
    // const [text2, setText2] = useState();

    // const textChange1 = (e) => {
    //     setText1(e.target.value);
    // };

    // const textChange2 = (e) =>{
    //     setText2(e.target.value);
    // } 

    // const changeButtonText = () => {
    //     if(text1 === text2){
    //         return "일치"
    //     } 
    //     return "불일치"
    // }

    const [check, setCeheck] = useState({
        password : "",
        passwordCheck : "",
        isSame: true,
    });

    const change1 = (e) => {
        const {value} = e.target;
        setCeheck((prev) => {
            return {...prev, password:value, isSame: value == prev.passwordCheck}
        });
    };

    const change2 = (e) => {
        const {value} = e.target;
        setCeheck((prev) => {
            return {...prev, passwordCheck:value, isSame: value == prev.password}
        });
    };


    return (
        <div>
            <div className='p-3 flex gap-1 border border-black bg-slate-200'>
                <span>비밀번호</span>
                <input type="text" onChange={(e)=> change1(e)}/>
            </div>
            <div className='p-3 flex gap-1 border border-black bg-slate-200'>
                <span>비밀번호 확인</span>
                <input type="text" onChange={(e)=> change2(e)}/>
            </div>
            
            <button>{check.isSame? "일치" : "불일치"}</button>
        </div>
    );
};

export default Password;