import React from 'react'
import { BrowserRouter as Router, Switch, Route } from "react-router-dom"
import '../node_modules/bootstrap/dist/css/bootstrap.min.css'

import Login from './pages/Login'
import SignUp from './pages/SignUp'
import Home from './pages/Home'
import ForgotPassword from './pages/ForgotPassword'

function App() {
  return (
    <Router>
      <Switch>
        <Route exact path='/' component={Login} />
        <Route path="/sign-in" component={Login} />
        <Route path="/sign-up" component={SignUp} />
        <Route path="/home" component={Home} />
        <Route path="/forgot-password" component={ForgotPassword} />
      </Switch>
    </Router>
  )
}

export default App
