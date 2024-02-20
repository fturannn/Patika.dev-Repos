import React from 'react'
import "./Purchase.css"

function Purchase() {
  return (
    <section className="purchase">
      <div className="purchase-container">
        <h2 className="titles">PURCHASE FROM US</h2>
        <div className="line-item"></div>
        <p className="desc-p">
          Lorem ipsum dolor, sit amet consectetur adipisicing elit. Numquam,
          labore?
        </p>
        <div className="purchase-box">
          <div className="purchase-card">
            <img
              src="./src/assets/purchase1.jpg"
              alt="Kettlebell 5 kg"
              className="purchase-img"
            />
            <p>Kettlebell / 5kg</p>
            <p className="price"><s>89,99$</s> / 59,99$</p>
            <p className="add-to-card">Add To Card</p>
            <i className="fa-solid fa-cart-shopping"></i>
          </div>
          <div className="purchase-card">
            <img
              src="./src/assets/purchase2.jpg"
              alt="Treadmill"
              className="purchase-img"
            />
            <p>Treadmill</p>
            <p className="price"><s>899,99$</s> / 599,99$</p>
            <p className="add-to-card">Add To Card</p>
            <i className="fa-solid fa-cart-shopping"></i>
          </div>
          <div className="purchase-card">
            <img
              src="./src/assets/purchase3.jpg"
              alt="Adjustable Dumbbell"
              className="purchase-img"
            />
            <p>Adjustable Dumbbell</p>
            <p className="price"><s>89,99$</s> / 59,99$</p>
            <p className="add-to-card">Add To Card</p>
            <i className="fa-solid fa-cart-shopping"></i>
          </div>
          <div className="purchase-card">
            <img
              src="./src/assets/purchase4.jpg"
              alt="Kettlebell 3 kg"
              className="purchase-img"
            />
            <p>Kettlebell / 3kg</p>
            <p className="price"><s>89,99</s> / 59,99$</p>
            <p className="add-to-card">Add To Card</p>
            <i className="fa-solid fa-cart-shopping"></i>
          </div>
        </div>
      </div>
    </section>
  )
}

export default Purchase