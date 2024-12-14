import { Button, Container, Heading, TextField } from '@radix-ui/themes/dist/cjs/index.js';
import React from 'react';
import Title from '../presentation/Title';
import Input from '../presentation/Input';

const Contents = () => {
    return (
        <Container style={{border:"1px solid red"}} size={"3"} p={"5"}> 
            <Title />
            <Input />
        </Container>
    );
};

export default Contents;