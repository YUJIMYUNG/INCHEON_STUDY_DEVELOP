import React, { useState } from 'react';

// 모두 통과되면 아이디가 유효합니다
const Register = () => {
    const [msg, setMsg] = useState("");
    const change = (e) => {
      const { value } = e.target;
      setMsg((v) => {
        if (value.length < 4 || 12 < value.length)
          return "글자 수가 맞지 않습니다.";
        else if (
          !value.includes("@") &&
          !value.includes("#") &&
          !value.includes("&")
        )
          return "특수문자가 필요합니다.";
        else return "아이디가 유효합니다.";
      });
    };
  
    return (
      <>
        <input onChange={(e) => change(e)} type="text" />
        <span>{msg}</span>
      </>
    );
  };
export default Register;