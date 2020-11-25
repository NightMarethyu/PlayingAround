import React from 'react';
import { data } from '../../../data';

const UseStateArray = () => {
  const [ people, setPeople ] = React.useState(data)

  const removeItem = (id) => {
    // There are two ways of setting this up. creating a new
    // variable and doing the logic there, or doing the logic in the 
    // setFuncion, the note is an example. The logic is the same

    // let newPeople = people.filter((person) => person.id !== id)
    setPeople(people.filter((person) => person.id !== id))
  }

  return (<>
  {
    people.map((person) => {
      const { id, name } = person
      return (
      <div key={id} className='item'>
        <h4>{name}</h4>
        <button onClick={() => removeItem(id)}>remove</button>
      </div>
      )
    })
  }
  <button className="btn" onClick={() => setPeople([])}>
    Clear Items
  </button>
  </>);
};

export default UseStateArray;
