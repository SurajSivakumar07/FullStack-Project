import React, { useEffect, useState } from 'react'

import "./nav.css"

import { Link } from 'react-router-dom'
import axios from 'axios'
import Display from './Display'

export default function Nav() {

  return (
    <>
      <div className='nav-wrap'>  

        <ul>

            <li>
                <Link to="/">Home</Link>
                
            </li>
            <li>

            <Link to="/add">add</Link>

            </li>
          
          <li>
            <Link to="/delete">delete</Link>
          </li>
          <li>
            <Link to="/update">put</Link>
          </li>
            
            
         </ul> 
           
      </div>



 

    </>
  )
}
