import React from 'react'
import { BrowserRouter as Router, Switch, Route } from "react-router-dom"
import { positions, Provider } from "react-alert"
import AlertTemplate from "react-alert-template-basic"
import '../node_modules/bootstrap/dist/css/bootstrap.min.css'

import { Header } from './components'
import { ForgotPassword, Home, Login, SignUp } from './pages'

const options = {
  timeout: 4000,
  position: positions.BOTTOM_CENTER
};

function App() {
  return (
    <Provider template={AlertTemplate} {...options}>
      <Router>
        <Header
          classTitle="navbar navbar-light text-light bg-dark"
          title="Central de Erros" />
        <Switch>
          <Route exact path='/' component={Login} />
          <Route path="/sign-in" component={Login} />
          <Route path="/sign-up" component={SignUp} />
          <Route path="/home" component={Home} />
          <Route path="/forgot-password" component={ForgotPassword} />
        </Switch>
      </Router>
    </Provider>
  )
}

export default App
