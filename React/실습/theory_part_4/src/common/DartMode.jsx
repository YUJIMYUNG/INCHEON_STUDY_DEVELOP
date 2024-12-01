import React, { useState } from 'react';
import { CiCloudSun } from "react-icons/ci";
import { CiCloudMoon } from "react-icons/ci";



const DartMode = () => {

    // react-icons를 활용해서 햇님과 달님 아이콘을 사용하여
    // 햇님 아이콘 버튼을 누르면 달님이 나오고, 동시에 alert 화이트모드!
    // 달님 아이콘 버튼을 누르면 햇님이 나오고, 동시에 alert 다크모드!

    const [isDarktMode, setIsDarkMode] = useState(false);
    
    const change = (e) => {
        alert(isDarktMode ? "화이트모드" : "다크모드");
        setIsDarkMode((v) => {
            return !v;
        });
    }
    
    return (


        <div>
            <button onClick={()=>change()}>
                {isDarktMode ?  <CiCloudMoon /> : <CiCloudSun /> }
            </button>

        </div>
    );
};

export default DartMode;