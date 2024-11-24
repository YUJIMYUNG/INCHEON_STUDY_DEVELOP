import Button from "./Button";


const StateButton = ({contents, isSelected}) => {
    return (
        <Button style={{
            padding:"10px 40px", 
            backgoundColor: isSelected ? "black" : "whilte", 
            color: isSelected? "white" : "black"}} contents={contents} />
    );
};

export default StateButton;