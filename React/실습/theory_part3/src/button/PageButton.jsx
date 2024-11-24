import Button from "./Button";


const PageButton = ({contents}) => {
    return (
        <Button style={{
            padding:"15px 70px",
            backgroundColor: "white",
            color: "black",
            border: "2px soild black",
            borderRadius: "8px"
            }} 
            contents={contents}
        />
    );
};

export default PageButton;