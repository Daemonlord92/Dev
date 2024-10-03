import { useState } from 'react'
import './App.css'
import Navbar from './static/Navbar'
import MonsterIndex from './component/monster/MonsterIndex'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <Navbar/>
      <MonsterIndex/>
    </>
  )
}

export default App
