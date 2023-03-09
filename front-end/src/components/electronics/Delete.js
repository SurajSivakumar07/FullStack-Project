import axios from 'axios'
import React, { useEffect, useRef, useState } from 'react'
import Nav from '../nav/Nav';
import "./electronics.css"

export default function Delete() {

 
  const btnRef=useRef();
  const[data,setData]=useState([]);
 

  useEffect(()=>{
    axios.get("http://localhost:8080/electronics")
    .then(res=>{console.log(res.data); setData(res.data)})
  },[])
  
    const btn=async()=>{

        const id=btnRef.current.value;
        await axios.delete(`http://localhost:8080/electronics/${id}`)
        .then(res=>{
        if(res.data=="deleted"){
          alert("delete")
          window.location.reload()
        }
        }
        
        );
    }
  return (
    <>
    <Nav />

    <div className='delete'>

    <input type="text"  ref={btnRef}/>
      <button onClick={btn}>
        Delete
      </button>
    </div>

    <div className='delete-wrap'>
          
    {data.map((items)=>

    <div className='delete-nav' key={items.id}>

        <p>ID:{items.id}</p>
        <p>IMGURL:{items.img}</p>
        <p>TYPE:<span>{items.name}</span></p>

      
        <p>BRAND:<span>{items.brand}</span></p>
      
        <p>RATING:<span>{items.rating}</span></p>


      
    </div>


    )}
    </div>

    
    </>
  )
}
