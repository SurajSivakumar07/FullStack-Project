import axios from 'axios'
import React, { useEffect, useRef, useState } from 'react'
import { ref, uploadBytesResumable, getDownloadURL,getStorage } from "firebase/storage";

import { storage } from '../Firebase';
import Nav from '../nav/Nav';

import "./electronics.css"
import { async } from '@firebase/util';
import { useNavigate } from 'react-router';

export default function ElectronicsUpdate(){


    const idRef=useRef();
    const brandRef=useRef();
    const ratingRef=useRef();
    const descriptionRef=useRef()
  

    const [file,setFile]=useState();
    const [downlaod,setDownload]=useState();
    const navigate=useNavigate();

    const btnHandler=()=>{
        const storage = getStorage();
        const metadata = {
            contentType: 'image/jpeg'
          };
         
          const storageRef = ref(storage, 'images/' + file.name);
          const uploadTask = uploadBytesResumable(storageRef, file, metadata);
      
          uploadTask.on('state_changed',
            (snapshot) => {
              
              const progress = (snapshot.bytesTransferred / snapshot.totalBytes) * 100;
              console.log('Upload is ' + progress + '% done');
              switch (snapshot.state) {
                case 'paused':
                  console.log('Upload is paused');
                  break;
                case 'running':
                  console.log('Upload is running');
                  break;
              }
            }, 
            (error) => {
              
              switch (error.code) {
                case 'storage/unauthorized':
                 
                  break;
                case 'storage/canceled':
                  
                  break;
          
                // ...
          
                case 'storage/unknown':
                   
                  break;
              }
            }, 
            () => {
              getDownloadURL(uploadTask.snapshot.ref).then((downloadURL) => {
                 setDownload(downloadURL)
                console.log('File available at', downloadURL);
              });
            }
          );

    }
    const formHandler=(e)=>{

        e.preventDefault();
       
    
    axios.put("http://localhost:8080/electronics",{
        id:idRef.current.value,
        name:descriptionRef.current.value,
        brand:brandRef.current.value,
        rating:ratingRef.current.value,
        img:downlaod
        
   }
  )
    .then(
       res=>{
       console.log(res.data)
     
       }
    ).then(err=>console.log(err))



    }
  return (
    <>
        <Nav />


    <div className='add-wrap'>

                <form onSubmit={formHandler}>
                    <input type="text"   ref={idRef} placeholder="id"  required/>
                    <input type="text"  ref={descriptionRef}   placeholder="Type" />
                    <input type="text"  ref={brandRef}   placeholder="Brand" />
                    <input type="text"    ref={ratingRef} placeholder="rating" />
                    <input type="file" onChange={(e)=>setFile(e.target.files[0])} />
                    <button onClick={btnHandler}>upload</button>
                    <input type="submit"></input>
                </form>
    </div>
        
      
    </>
  )
}
