import React from 'react'
import { BrowserRouter as Router, Switch, Route } from "react-router-dom"
import '../node_modules/bootstrap/dist/css/bootstrap.min.css'

import { Header } from './components'
import { ForgotPassword, Home, Login, SignUp } from './pages'

function App() {
  return (
    <Router>
      <Header
        classTitlePage="navbar navbar-light text-light bg-dark"
        titlePage="Central de Erros" />
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
