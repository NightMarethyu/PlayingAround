import React, { useState } from 'react';

const UseStateCounter = () => {
  const [value, setValue] = useState(0)
  
  const reset = () => {
    setValue(0)
  }

  const complexIncrease = () => {
    setTimeout(() => {
      // setValue(value + 1) This will load the value of the counter before an 
      // update so if you click again before the number updates it will only update once
      
      setValue((prevState) => {
        return prevState + 1
      })
    }, 2000)
  }

  return (
  <>
    <section style={{ margin: '4rem 0' }}>
      <h2>Regular Counter</h2>
      <h1>{value}</h1>
      <button className="btn" onClick={() => setValue(value - 1)}>
        decrease
      </button>
      <button className="btn" onClick={reset}>
        reset
      </button>
      <button className="btn" onClick={() => setValue(value + 1)}>
        increase
      </button>
    </section>
    <section style={{ margin: '4rem 0' }}>
      <h2>More Complex Counter</h2>
      <h1>{value}</h1>
      <button className="btn" onClick={complexIncrease}>
        increase later
      </button>
    </section>
  </>
  );
};

export default UseStateCounter;
