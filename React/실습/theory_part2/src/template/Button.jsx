import { radiusMap } from "./style/border";
import { colorMap } from "./style/color";

const Button = (props) => {




    

    return (
        <div>
           <button style={{padding:"10px 45px",
                    margin:"10px",
                    backgroundColor:colorMap[props.backgroundColor], 
                    borderRadius:radiusMap[props.borderRadius], 
                    border: `1px solid ${colorMap[props.borderColor]}`, 
                    color:"white" 
           }}>Button</button>
        </div>
    );
};

export default Button;