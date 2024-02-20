import React from 'react'
import "./BMI.css"

function BMI() {
  return (
    <section className="bmi">
      <div className="bmi-content">
        <h2>BMI Calculator</h2>
        <p>
          Lorem ipsum, dolor sit amet consectetur adipisicing elit. Reiciendis
          rerum recusandae sapiente exercitationem! Accusantium quia facilis
          dolorem aperiam beatae dignissimos.
        </p>
        <p>
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Error magni
          autem quae aliquid rerum culpa sed omnis nam alias sapiente.
        </p>
        <div className="calculator">
          <input
            type="text"
            id="height"
            name="height"
            placeholder="Your Height"
          />
          <label for="height"> cm </label>
          <input
            type="text"
            id="weight"
            name="weight"
            placeholder="Your Weight"
          />
          <label for="weight"> kg </label>
        </div>
      </div>
      <div className="bmi-index">
        <h3>Your BMI</h3>
        <img src="./src/assets/bmi-index.jpg" alt="BMI Index" className="bmi-img" />
        <div className="arrow-up"></div>
      </div>
    </section>
  )
}

export default BMI