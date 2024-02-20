import React from 'react'
import "./Card.css"

function Card() {
  return (
    <section id="card">
      <div className="container-card">
        <div className="card-item">
          <h3>325</h3>
          <p>Course</p>
        </div>
        <div className="card-item">
          <h3>405</h3>
          <p>Work Out</p>
        </div>
        <div className="card-item">
          <h3>305</h3>
          <p>Working Hour</p>
        </div>
        <div className="card-item">
          <h3>705</h3>
          <p>Happy Client</p>
        </div>
      </div>
    </section>
  )
}

export default Card