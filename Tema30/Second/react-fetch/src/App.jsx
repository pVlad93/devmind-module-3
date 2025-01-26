import { Routes, Route } from 'react-router'
import './App.css'
import TodosScreen from './components/TodosScreen'
import PostComponent from './components/PostComponent'

function App() {

  return (
    <>
      <Routes>
        <Route path="/todo" element={<TodosScreen/>}/>
        <Route path="/posts" element={<PostComponent/>}/>
      </Routes>
    </>
  )
}

export default App
