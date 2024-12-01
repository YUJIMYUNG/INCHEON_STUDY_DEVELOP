
import { FaHome } from "react-icons/fa";
import { FaSearch } from "react-icons/fa";
import Icon from "./presentation/icon/Icon"; 
import Button from "./common/Button";
import Toggle from "./common/Toggle";


function App() {
  return (
    <div className="App">
      <Icon icon={<FaHome />} title={"Home"} />
      <Icon icon={<FaSearch />} title={"Search"} />
      <Button coffeeName={"아이스아메리카노"} num={10}/>

      <Toggle />
    </div>
  );
}

export default App;
