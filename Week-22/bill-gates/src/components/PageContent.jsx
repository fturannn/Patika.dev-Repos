import React from "react";
import data from "../data";
import { useState } from "react";

const PageContent = () => {
  return (
    <div className="page-content">
      {data.map((item) => {
        const [count, setCount] = useState(0);

        function buy() {
          setCount(count + 1);
          item.count += 1;
        }

        function sell() {
          if (count > 0) {
            setCount(count - 1);
            item.count -= 1;
          }
        }
        return (
          <div key={item.title} className="item">
            <img src={item.image} alt={item.title} />
            <h3>{item.title}</h3>
            <p>${item.price}</p>
            <div className="buttons">
              <button className="button" onClick={sell}>
                Sell
              </button>
              <input type="text" className="count" value={count} />
              <button className="buy button" onClick={buy}>
                Buy
              </button>
            </div>
          </div>
        );
      })}
    </div>
  );
};

export default PageContent;
