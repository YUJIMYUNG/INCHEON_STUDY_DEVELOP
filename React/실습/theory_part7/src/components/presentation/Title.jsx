import { Container, Heading } from '@radix-ui/themes/dist/cjs/index.js';
import React from 'react';

const Title = () => {
    return (
        <div>
       
            <Heading align={"center"} as="h1" size={"8"} weight={"bold"} color={"indigo"} highContrast>To do List 🩵</Heading>
        </div>
    );
};

export default Title;