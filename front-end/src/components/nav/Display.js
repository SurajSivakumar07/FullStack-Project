import {React,useState,useEffect} from 'react'
import axios from 'axios'


export default function Display() {
    const [data,setData]=useState([]);
    useEffect(()=>{
      axios.get("http://localhost:8080/electronics")
      .then(res=>{
        console.log(res.data)
        setData(res.data);
      
      })
    },[])
  return (
    <>
      
          
    <div className='elec-wrap'>

{data.map((items)=>

    <div className='elec-nav' key={items.id}>
        <img src={items.img} />
        <p>TYPE:<span>{items.name}</span></p>

      
        <p>BRAND:<span>{items.brand}</span></p>
      
        <p>RATING:<span>{items.rating}</span></p>

 
       
    </div>


)}

</div>
    </>
  )
}
