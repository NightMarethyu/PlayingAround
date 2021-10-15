import React, { useState, useEffect } from 'react'

function CheckboxLimited({ id, choiceLimit, title, prompt, options}) {
  const [ limit, setLimit ] = useState([])

  const handleChange = (e) => {
    if (e.target.checked) {
      setLimit(limit + 1)
    } else {
      setLimit(limit - 1)
    }
  }

  useEffect(() => {
    if (limit === choiceLimit) {
      let boxes = document.getElementsByClassName(`option${id}`)
      boxes.map((b) => {
        b.disabled = true
        return console.log("Set Checkboxes")
      })
    }
  }, [limit, choiceLimit, id])

  return (
    <div>
      <h3>{ title }</h3>
      <p>{ prompt }</p>
      {options.map((choice) => {
        return <label>
          <input 
            type="checkbox"
            className={`option${id}`}
            name={title}
            onChange={handleChange}
          /> {choice.title}
        </label>
      })}
    </div>
  )
}

export default CheckboxLimited
