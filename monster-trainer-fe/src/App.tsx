import { useState } from 'react'
import './App.css'
import Navbar from './static/Navbar'
import MonsterIndex from './component/monster/MonsterIndex'
import { Route, Routes } from 'react-router-dom'
import Footer from './static/Footer'
import UpdateMonster from './component/monster/UpdateMonster'
import Register from './component/auth/Register'
import Login from './component/auth/Login'

function App() {

  return (
    <>
      <Navbar/>
      <Routes>
        <Route path="/" element={<MonsterIndex/>}/>
        <Route path="/secret" element={<Footer/>} />
        <Route path='/update' element={<UpdateMonster/>} />
        <Route path='/register' element={<Register/>}/>
        <Route path='/login' element={<Login />} />
      </Routes>
    </>
  )
}

export default App
