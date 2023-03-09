import axios from 'axios'
import React, { useEffect, useRef, useState } from 'react'
import Nav from '../nav/Nav';
import { getStorage, ref, uploadBytesResumable, getDownloadURL } from "firebase/storage";


import "./electronics.css"
import { useNavigate } from 'react-router';

export default function ElecAdd() {


    const idRef=useRef();
    const imgRef=useRef();
    const brandRef=useRef();
  
    const ratingRef=useRef();

    const descriptionRef=useRef()

 

    const[file,setFile]=useState();
    const[img,setImg]=useState();

    const[progerss,setProgess]=useState();


    const navigate=useNavigate();
    const btnHanlder=()=>{
      const storage = getStorage();

 
/** @type {any} */
const metadata = {
  contentType: 'image/jpeg'
};

// Upload file and metadata to the object 'images/mountains.jpg'
const storageRef = ref(storage, 'images/' + file.name);
const uploadTask = uploadBytesResumable(storageRef, file, metadata);

// Listen for state changes, errors, and completion of the upload.
uploadTask.on('state_changed',
  (snapshot) => {
    // Get task progress, including the number of bytes uploaded and the total number of bytes to be uploaded
    const progress = (snapshot.bytesTransferred / snapshot.totalBytes) * 100;

    setProgess(progress);
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
    // A full list of error codes is available at
    // https://firebase.google.com/docs/storage/web/handle-errors
    switch (error.code) {
      case 'storage/unauthorized':
        // User doesn't have permission to access the object
        break;
      case 'storage/canceled':
        // User canceled the upload
        break;

      // ...

      case 'storage/unknown':
        // Unknown error occurred, inspect error.serverResponse
        break;
    }
  }, 
  () => {
    // Upload completed successfully, now we can get the download URL
    getDownloadURL(uploadTask.snapshot.ref).then((downloadURL) => {

      setImg(downloadURL)
      console.log('File available at', downloadURL);
    });
  }
);
    }


    const formHandler=(e)=>{
        e.preventDefault();


   if(progerss==100){

        axios.post("http://localhost:8080/electronics",{
          id:idRef.current.value,
          name:descriptionRef.current.value,
          brand:brandRef.current.value,
          rating:ratingRef.current.value,
          img:img
    }
    )
      .then(
        res=>{
        console.log(res.data)
        if(res.data=="added"){
          navigate("/");
        }
        }
      ).then(err=>console.log(err))



}

else{
  alert("File dint upload")
}
  

}

  return (
    <>
        <Nav />


    <div className='add-wrap'>

                <form onSubmit={formHandler}>
                    <input type="text"   ref={idRef} placeholder="id"  required/>
                    <input type="text"  ref={descriptionRef}   placeholder="Type" required />
                    <input type="text"  ref={brandRef}   placeholder="brand" required/>

                    <input type="text"    ref={ratingRef} placeholder="rating" required />
                 
                    <input type="file" onChange={(e)=>setFile(e.target.files[0])} required/>

                    <button onClick={btnHanlder}>Upload</button>

                    <input type="submit"></input>
                </form>
    </div>
        
      
    </>
  )
}
