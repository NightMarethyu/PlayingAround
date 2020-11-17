import React, { useState } from 'react';

// I wanted to mess around with the variables and try to set the background color
// using random values. It took some doing, and I didn't want to lose my notes
// the key here is I needed to use the backtick "`" and "$" to access the variable I created

const UseStateBasics = () => {
  const [color,setColor] = useState('#fff')

  const handleClick = () => {

    let r = Math.round(Math.random() * 255).toString(16)
    let g = Math.round(Math.random() * 255).toString(16)
    let b = Math.round(Math.random() * 255).toString(16)
    setColor('#' + r + g + b)
  }
  return (
    <React.Fragment>
    <h1 style={{background: `${color}`}}>Color Changer</h1>
    <button className="btn" onClick={handleClick}>Change Color</button>
    </React.Fragment>
  );
};

export default UseStateBasics;
