
const Info = (props) => {
const backgroundColorMap = {
    notColmplated : "#FEE9EC",
    standby : "#DAEDBD"
}

const fontColorMap = {
    notColmplated : "#EA0029",
    standby : "#5D7D2B"
}

    return (
        <div style={{backgroundColor:backgroundColorMap[props.backgroundColor], width:"400px", height:"200px"}}>
            <div style={{fontSize:"15px"}}>
                <span>{props.model}</span>
                <span>{props.isConfirm ? "대기" : "미완료"}</span>
            </div>
          
            <div style={{fontSize:"25px", color:fontColorMap[props.color]}}>
                <span>{props.carNumber}</span>
            </div>           
        </div>
    );
};

export default Info;