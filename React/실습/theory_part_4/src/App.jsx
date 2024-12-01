
import { FaHome } from "react-icons/fa";
import { FaSearch } from "react-icons/fa";
import Icon from "./presentation/icon/Icon"; 
import Button from "./common/Button";
import Toggle from "./common/Toggle";
import Count from "./common/Count";
import Input from "./common/Input";
import Register from "./common/Register";


function App() {
  return (
    <div className="App">
      <Icon icon={<FaHome />} title={"Home"} />
      <Icon icon={<FaSearch />} title={"Search"} />
      <Button coffeeName={"아이스아메리카노"} num={10}/>

      <Count num={0} />
      <Input />
      <Register />

      <Toggle />
    </div>
  );
}

export default App;
