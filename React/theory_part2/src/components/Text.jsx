import React from 'react';

const Text = (props) => {
    return (
        <div style={{fontSize:"20px", color:props.color || "black"}}>
            {props.name || "Geust"} 님 안녕하세요!
        </div>
    );
};

export default Text;