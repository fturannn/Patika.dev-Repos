import React from 'react'
import "./Classes.css"
function Classes() {
  return (
    <section id="classes">
      <div className="bg-shape"></div>
      <div className="classes-container">
        <h2 className="titles">OUR CLASSES</h2>
        <div className="line-item"></div>
        <p className="desc-p">
          Lorem ipsum dolor, sit amet consectetur adipisicing elit. Numquam,
          labore?
        </p>
        <div className="buttons">
          <button className="group-btn">
            <div className="selection"></div>
            Yoga
          </button>
          <button className="group-btn">
            <div></div>
            Group
          </button>
          <button className="group-btn">
            <div></div>
            Solo
          </button>
          <button className="group-btn">
            <div></div>
            Stretching
          </button>
        </div>
        <div className="group-content">
          <div className="desc">
            <h3>Why are your Yoga?</h3>
            <p>
              Lorem ipsum dolor sit amet consectetur adipisicing elit. Neque
              quidem quis earum officiis quam fugit placeat impedit incidunt
              amet assumenda laboriosam ipsam quisquam perferendis quibusdam,
              autem, illo eos cupiditate! Debitis aut beatae alias ullam nobis?
            </p>
            <h3>When comes Yoga Your Time.</h3>
            <p>Saturday-Sunday: 8:00am - 10.00am</p>
            <p>Monday-Tuesday: 10:00am - 12.00pm</p>
            <p>Wednesday-Friday: 3:00pm - 6.00pm</p>
          </div>
          <img
            src="./src/assets/yoga.jpg"
            alt="A woman who does yoga"
            className="class-img"
          />
        </div>
      </div>
    </section>
  )
}

export default Classes