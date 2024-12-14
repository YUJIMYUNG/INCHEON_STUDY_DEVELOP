import { Button, TextField } from '@radix-ui/themes/dist/cjs/index.js';
import React from 'react';

const Input = () => {
    return (
        <TextField.Root placeholder='To Do List 입력하기 !' size="3">
        <Button>
            Add
        </Button>

    </TextField.Root>
    );
};

export default Input;