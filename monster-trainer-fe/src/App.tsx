import { useState } from 'react'
import './App.css'
import Navbar from './static/Navbar'
import MonsterIndex from './component/monster/MonsterIndex'
import { Route, Routes } from 'react-router-dom'
import Footer from './static/Footer'
import UpdateMonster from './component/monster/UpdateMonster'

function App() {

  return (
    <>
      <Navbar/>
      <Routes>
        <Route path="/" element={<MonsterIndex/>}/>
        <Route path="/secret" element={<Footer/>} />
        <Route path='/update' element={<UpdateMonster/>} />
      </Routes>
    </>
  )
}

export default App
