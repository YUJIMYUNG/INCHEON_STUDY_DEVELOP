import { ColorMap } from "../style/color";

const CarValueText = ({value}) => {
    return (
        <div>
             <span stle ={{color:ColorMap.black}}>{value}</span>
        </div>
    );
};

export default CarValueText;