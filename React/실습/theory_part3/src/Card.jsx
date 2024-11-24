
const Card = ({children}) => {
    return (
        <div style={{display:"flex",
                flexDirection:"column",
                gap:"10px",
                border:"1px solid black"
        }}>
                {children}
        </div>
    );
};

export default Card;