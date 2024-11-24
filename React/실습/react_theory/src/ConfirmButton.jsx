const ConfirmButton = () => {
    const css = {
        width:"180px",
        height:"50px",
        backgroundColor:"black",
        border:"soild black 1px;",
        borderRadius:"5px",
        fontSize:"18px",
        fontWeight:"bold",
        color:"white"
    };
    return(
        <button style={css}>확정</button>
    );
};

export default ConfirmButton;
