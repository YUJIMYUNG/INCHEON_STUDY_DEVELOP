import React, { useState } from 'react';
import Input from '../atom/Input';
import Button from '../atom/Button';
import CheckBox from '../atom/CheckBox';

type AddTodoProps = {
    func : (todo:string) => void;
}

const AddTodo = ({func} : AddTodoProps) => {
    const [inputValue, setInputValue] = useState<string>("");

    const change = (e:React.ChangeEvent<HTMLInputElement>) => 
        setInputValue((prev) => e.target.value)

    return (
        <div style={{display: 'flex',
                    boxShadow: "rgba(17, 12, 46, 0.15) 0px 48px 100px 0px;",
                    justifyContent:"space-between",
                    padding:"10px 20ox"}}>
            <Input placeholder='Add a new Task...' change={change}/>
            <Button click={() => func(inputValue)} content='+' />
            
        </div>
    );
};

export default AddTodo;