import React, { useState } from 'react'

// import my home-brew things
import Limited from '../home-brew/CheckboxLimited'

// get the data for the quiz
import { quiz, results } from '../quizzes/vacation'

const data = quiz
const res = results

function Vacation() {
  const [ score, setScore ] = useState(0)

  const handleSubmit = (e) => {
    e.preventDefault();
  }

  return <>
    <h1>{ data.title }</h1>
    <form onSubmit={handleSubmit}>
      {data.questions.map((question) => {
        if ( question.chooseOne ) {
          return <div>
            <h3>{ question.title }</h3>
            <p>{ question.prompt }</p>
            {question.options.map((o) => {
              return <label>
                <input 
                  type="radio" 
                  value={o.points} 
                  name={question.title}
                /> {o.title}
                <br />
              </label>
            })}
          </div>
        } else {
          if (question.choiceLimit) {
            <Limited key={question.id} {...question} />
          } else {
            return <div>
              <h3>{ question.title }</h3>
              <p>{ question.prompt }</p>
              {question.options.map((o) => {
                return <label>
                  <input type="checkbox" name={o.title} />
                  {o.title}
                  <br />
                </label>
              })}
            </div>
          }
        }
      })}
      <button type="submit">Get Score</button>
    </form>
  </>
}

export default Vacation
