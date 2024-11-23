import Button from "./Button";

const ButtonGrid = () => {
    return (
    <div style={{display:"grid", gridTemplateColumns:"3, 1fr"}}>
 
      <Button backgroundColor="parimary" borderColor="parimary"/>
      <Button backgroundColor="hover" borderColor="hover"/>
      <Button backgroundColor="deactive" borderColor="deactive"/>
      <Button backgroundColor="parimary" borderRadius="smooth" borderColor="parimary"/>
      <Button backgroundColor="hover" borderRadius="smooth" borderColor="hover"/>
      <Button backgroundColor="deactive" borderRadius="smooth" borderColor="deactive"/>
      <Button backgroundColor="parimary" borderRadius="circle" borderColor="parimary"/>
      <Button backgroundColor="hover" borderRadius="circle" borderColor="hover"/>
      <Button backgroundColor="deactive" borderRadius="circle" borderColor="deactive"/>
    </div>
    );
};

export default ButtonGrid;