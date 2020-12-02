import React from 'react'
import { Link } from 'react-router-dom';

// Styling import
import '../styling/navbar.css';

function Navbar() {
  return (
    <nav>
      <ul>
        <li>
          <Link to="/">Home</Link>
        </li>
        <li>
          <Link to="/quizzes">Quizzes</Link>
        </li>
      </ul>
    </nav>
  )
}

export default Navbar
