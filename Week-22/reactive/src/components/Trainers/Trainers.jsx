import React from 'react'
import "./Trainers.css"

function Trainers() {
  return (
    <section id="trainers">
      <div className="trainer-container">
        <h2 className="titles">OUR BEST TRAINERS</h2>
        <div className="line-item"></div>
        <p className="desc-p">
          Lorem ipsum dolor, sit amet consectetur adipisicing elit. Numquam,
          labore?
        </p>
        <div className="trainers-box">
          <div className="img-box">
            <div className="before"></div>
            <img
              src="./src/assets/trainer1.jpg"
              alt="Trainer 1"
              className="trainer-img"
            />
            <div className="after"></div>
            <div className="trainer-flag hidden"></div>
            <p className="trainer-name hidden">Ayşe</p>
          </div>
          <div className="img-box">
            <div className="before"></div>
            <img
              src="./src/assets/trainer2.jpg"
              alt="Trainer 1"
              className="trainer-img"
            />
            <div className="after"></div>
            <div className="trainer-flag hidden"></div>
            <p className="trainer-name hidden">Ersin Mutlu</p>
          </div>
          <div className="img-box">
            <div className="before"></div>
            <img
              src="./src/assets/trainer3.jpg"
              alt="Trainer 1"
              className="trainer-img"
            />
            <div className="after"></div>
            <div className="trainer-flag hidden"></div>
            <p className="trainer-name hidden">Fatma</p>
          </div>
        </div>
      </div>
    </section>
  )
}

export default Trainers