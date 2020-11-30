import React, { useState } from 'react';
import { data } from '../../../data'

// more components
// fix - context api, redux (for more complex cases)

// Basically this section was talking about a problem and how the next section will fix it
// It's useful to know this for simple apps, but the next section will make it easier
// for more complex apps to run better

const PropDrilling = () => {
  const [people, setPeople] = useState(data)
  const removePerson = (id) => {
    setPeople((people) => {
      return people.filter((person) => person.id !== id)
    })
  }

  return (
  <section>
    <h3>Prop Drilling</h3>
    <List people={people} removePerson={ removePerson } />
  </section>
  );
};

const List = ({ people, removePerson }) => {
  return <>
  {people.map((person) => {
    return <SinglePerson key={person.id} {...person } removePerson={ removePerson } />
  })}
  </>
}

const SinglePerson = ({ id, name, removePerson }) => {
  return <div className="item">
    <h4>{ name }</h4>
    <button className="btn" onClick={() => removePerson(id)}>Remove</button>
  </div>
}

export default PropDrilling;
