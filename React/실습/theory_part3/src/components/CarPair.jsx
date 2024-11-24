import CarInfoText from "./CarInfoText";
import CarValueText from "./CarValueText";


const CarPair = (props) => {
    return (
        <div style={{display:"flex", justifyContent:"space-between"}}>
            <CarInfoText {...props} />
            <CarValueText {...props} />
        </div>
    );
};

export default CarPair;