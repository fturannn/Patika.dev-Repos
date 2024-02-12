import React from 'react'
import billgates from '../assets/billgates.jpg'

const Header = () => {
  return (
    <div className='header-container'>
        <img src={billgates} alt="Bill Gates" />
        <h1 className='header-h1'>Spend Bill Gates' Money</h1>
    </div>
  )
}

export default Header