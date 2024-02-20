import React from 'react'
import "./Review.css"

function Review() {
  return (
    <section id="review">
      <div className="review-container">
        <h2 className="titles">REVIEW CLIENT</h2>
        <div className="line-item"></div>
        <p className="desc-p">
          Lorem ipsum dolor, sit amet consectetur adipisicing elit. Numquam,
          labore?
        </p>
        <div className="client-reviews">
          <div className="client">
            <div className="client-info">
              <img src="./src/assets/client1.jpg" alt="Client 1" />
              <div className="name">
                <p>Diet Expert</p>
                <p>CFO</p>
              </div>
            </div>
            <div className="client-comment">
              <p>
                Lorem ipsum dolor, sit amet consectetur adipisicing elit. Eum
                libero neque atque sit eligendi beatae minus, pariatur numquam
                facilis aspernatur odit facere laboriosam recusandae ad. Laborum
                fuga ducimus ratione odio?
              </p>
            </div>
          </div>
          <div className="client">
            <div className="client-info">
              <img src="./src/assets/client2.jpg" alt="Client 2" />
              <div className="name">
                <p>Cardio Trainer</p>
                <p>CEO</p>
              </div>
            </div>
            <div className="client-comment">
              <p>
                Lorem ipsum dolor, sit amet consectetur adipisicing elit. Eum
                libero neque atque sit eligendi beatae minus, pariatur numquam
                facilis aspernatur odit facere laboriosam recusandae ad. Laborum
                fuga ducimus ratione odio?
              </p>
            </div>
          </div>
        </div>
      </div>
    </section>
  )
}

export default Review