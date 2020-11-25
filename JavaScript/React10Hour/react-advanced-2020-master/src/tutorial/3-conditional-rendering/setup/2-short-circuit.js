import React, { useState } from 'react';
// short-circuit evaluation
// ternary operator

const ShortCircuit = () => {
  const [text, setText] = useState('')
  const [isError, setIsError] = useState(false)
  const firstValue = text || 'first';
  const secondValue = text && 'second';
  console.log(firstValue)
  console.log(secondValue)

  // The reason this is being covered is because we can't use if statements
  // in the middle of a jsx return with React, but there are times we will
  // want to display things conditionally like that. We can use short-circuit
  // evaluation to get the same sort of result as an if statement but still
  // have it return something to make jsx happy

  return (<>
  {/*<h1>{firstValue}</h1>
  <h1>value : {secondValue}</h1>*/}

  <h1>{text || 'Kirito'}</h1>
  <button className="btn" onClick={() => setIsError(!isError)}>toggle error</button>
  {text && <h2>SAO</h2>}
  {!text && <h2>sword art online</h2>}
  <br />
  {isError && <>
  <h1>Error...</h1>
  <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
  </>}
  {isError ? <p>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p> : <p>The cake is a lie.</p>}
  </>);
};

export default ShortCircuit;
