import React, { useState, useEffect } from 'react';
// by default runs after every re-render
// cleanup function
// second parameter
const UseEffectBasics = () => {
  const [value, setValue] = useState(0);

  useEffect(() => {
    console.log("Rendered")
    if (value > 0) {
      document.title = `New Messages(${value})`
    }
  }, [value])
  // The array that is the second value in useEffect is a list of dependencies
  // You can make sure that useEffect is only called when certain values are updated
  // otherwise useEffect will be called everytime the page renders

  // You can have multiple useEffect hooks, This way you can have multiple dependencies
  useEffect(() => {
    console.log("First Render")
  }, [])

  return (
    <>
      <h2>{ value }</h2>
      <button className="btn" onClick={() => setValue(value + 1)}>Click Me</button>
    </>
  );
};

export default UseEffectBasics;
