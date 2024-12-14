
import { Button, Flex, Text } from '@radix-ui/themes/dist/cjs/index.js';


function App() {
  return (
    <div className="App">
        <p className='bg-gray-500'>tailwind test</p>
        <div>
          <Flex direction={"column"} gap={"2"}>
            <Text>radix test</Text>
            <Button>Go!</Button>
          </Flex>
        </div>
    </div>
  );
}

export default App;
