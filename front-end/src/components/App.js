 import React, { useEffect } from 'react'
 
 import axios from 'axios'
import { Route, Routes } from 'react-router'
import Nav from './nav/Nav'
import ElecAdd from './electronics/ElecAdd'
import Home from './Home'
import ElectronicsUpdate from './electronics/ElectronicsUpdate'
import Delete from './electronics/Delete'


 

 export default function App() {


  // useEffect(()=>{
  //     axios.post("http://localhost:8080/shoes",{
          
  //       id:"01",
  //       img:"http",
  //       brand:"nb",
  //       description:"new",
  //       price:200000,
  //       rating:5
  //  }
  // )
  //   .then(res=>console.log(res.data))
  // })
  
   return (
     <>
     <Routes>
      <Route path='/' element={ <Home />} />
      <Route path='/add' element={ <ElecAdd />} />
      <Route path='/update' element={ <ElectronicsUpdate />} />
      <Route path='/delete' element={ <Delete />} />


     </Routes>
     
     
        
          
     </>
   )
 }
 