import React, { useState } from 'react';

const FruitsButton = ({ a, b }) => {
    const [fruit, setFruit] = useState(a);
  
    const change = () => setFruit((v) => (v == a ? b : a));
  
    return (
      <button onClick={change} className="p-1 bg-green-600">
        {fruit}
      </button>
    );
  };
  

export default FruitsButton;