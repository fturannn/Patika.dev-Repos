import React from 'react'
import "./Navbar.css"

function navbar() {
  return (
    <div className="nav-container">
      <nav className="navbar">
        <a href="#"><img src="./src/assets/logo.png" alt="Sport Center Logo" /></a>
        <label form="menu-btn" className="menu-icon"
          ><i className="fa-solid fa-bars"></i
        ></label>
        <input type="checkbox" id="menu-btn" className="menu-btn" />
        <div className="navs">
          <a href="#" className="nav-item">Home</a>
          <a href="#classes" className="nav-item">Classes</a>
          <a href="#trainers" className="nav-item">Trainer</a>
          <a href="#review" className="nav-item">Review</a>
          <a href="#contact" className="nav-item">Contact</a>
          <button className="nav-item nav-btn">JOIN US</button>
        </div>
      </nav>
    </div>
  )
}

export default navbar