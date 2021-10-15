// Important React Imports
import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
// Navbar Import
import Navbar from './fragments/Navbar';
// Imports for pages on the site
import Home from './fragments/Home';
import Quizzes from './fragments/Quizzes';
import Error from './fragments/Error';
// Imports for quiz builds
import Vacation from './fragments/Vacation';

function App() {
  return <Router>
    <Navbar />
    <Switch>
      <Route exact path="/">
        <Home />
      </Route>
      <Route path="/quizzes">
        <Quizzes />
      </Route>
      <Route path="/quiz/vacation">
        <Vacation />
      </Route>
      <Route path="*">
        <Error />
      </Route>
    </Switch>
  </Router>;
}

export default App;
