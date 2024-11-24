const Cart = () => {
    const list = ["사과", "바나나", "멜론"];

    return(
        <ol>
            {list.map((x) => (
                <li>{x}</li>
            ))}
        </ol>
    ); 
};

export default Cart;