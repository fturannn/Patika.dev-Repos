import React from 'react'
import "./Footer.css"

function Footer() {
  return (
    <footer>
      <div className="footer-container">
        <img src="./src/assets/logo.png" alt="Logo" />
        <p>
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Magnam a
          incidunt voluptatum voluptates officia sequi dicta totam perspiciatis?
          Odio quidem labore unde illum cupiditate, rerum eligendi deleniti
          debitis dolorem adipisci? Quia distinctio at magni a! Unde minima ex
          eaque maxime?
        </p>
        <div className="info-and-links">
          <div className="information">
            <h3>Information</h3>
            <a href="#">About Us</a>
            <a href="#">Classes</a>
            <a href="#">Blog</a>
            <a href="#">Contact</a>
          </div>
          <div className="helpful-links">
            <h3>Helpful links</h3>
            <a href="#">Services</a>
            <a href="#">Supports</a>
            <a href="#">Terms & Condition</a>
            <a href="#">Privacy Policy</a>
          </div>
        </div>
      </div>
    </footer>
  )
}

export default Footer