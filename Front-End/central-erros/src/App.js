import React from 'react'
import { BrowserRouter as Router, Switch, Route } from "react-router-dom"
import '../node_modules/bootstrap/dist/css/bootstrap.min.css'

import Login from './pages/Login'
import SignUp from './pages/SignUp'
import Home from './pages/Home'

function App() {
  return (
    <Router>
      <Switch>
        <Route exact path='/' component={Login} />
        <Route path="/sign-in" component={Login} />
        <Route path="/sign-up" component={SignUp} />
        <Route path="/consulta" component={Home} />
      </Switch>
    </Router>
  )
}

export default App
