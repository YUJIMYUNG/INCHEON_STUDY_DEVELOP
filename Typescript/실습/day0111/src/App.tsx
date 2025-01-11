
import CheckSection from './molecules/CheckSection';
import AddTodo from './molecules/AddTodo';
import Text from './atom/Text';
import TodoList from './organism/TodoList';
import { useState } from 'react';

function App() {

  const [todoList, setTodoList] = useState<string[]>([]);

  const addTodo = (todo:string) => setTodoList((prev) =>[...prev, todo])

  return (
    <section style={{maxWidth:"800px",
                    margin:"0 auto",

    }}>
      <Text text={'TO-DO LIST'} css={{fontSize:"30px", textAlign:"center"}} />
      <AddTodo func={addTodo}/>
      <TodoList todoes={todoList}/>
    </section>
  );
}

export default App;
