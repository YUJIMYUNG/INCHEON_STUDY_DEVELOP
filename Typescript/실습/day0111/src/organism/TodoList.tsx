import React from 'react';
import CheckBox from '../atom/CheckBox';
import CheckSection from '../molecules/CheckSection';

type TodoListProps={
    todoes: string[];
}
const TodoList = ({todoes} : TodoListProps) => {
    return (
        <ul style={{display: 'flex',
            flexDirection:"column",
            boxShadow: "rgba(17, 12, 46, 0.15) 0px 48px 100px 0px;",
            justifyContent:"space-between",
            padding:"10px 20ox"}}>
        
        {todoes.map((v) => (
            <CheckSection label={v} />
        ))}    
        </ul>
    );
};

export default TodoList;