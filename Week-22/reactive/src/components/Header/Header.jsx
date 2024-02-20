import React from 'react'
import "./Header.css"

function Header() {
  return (
    <header>
      <div class="container-top">
        <h3>POWERFULL</h3>
        <h1>Group<br />Practice<br />With Trainer</h1>
        <p>
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Ducimus id
          cum illo corrupti obcaecati modi vitae mollitia blanditiis deserunt
          perferendis quis magnam sunt ex, dolorum suscipit dignissimos velit
          totam minus?
        </p>
        <button id="signup-btn">Sign Up</button>
        <button id="details-btn">Details</button>
      </div>
    </header>
  )
}

export default Header