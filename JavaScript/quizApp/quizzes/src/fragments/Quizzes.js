import React from 'react'
import { Link } from 'react-router-dom'
import { data } from '../quizzes/data'

function Quizzes() {
  return <>
      <h1>Quizzes</h1>
      {data.map((quiz) => {
        return (
          <div key={quiz.id} className='quizItem'>
            <h4>{quiz.title}</h4>
            <Link to={`/quiz/${quiz.source}`}>Take Quiz</Link>
          </div>
        )
      })}
    </>
}

export default Quizzes

