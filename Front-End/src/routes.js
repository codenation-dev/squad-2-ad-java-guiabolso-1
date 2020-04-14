import React from "react"
import { BrowserRouter, Switch, Route, Redirect } from "react-router-dom"
import { positions, Provider } from "react-alert"
import AlertTemplate from "react-alert-template-basic"
import '../node_modules/bootstrap/dist/css/bootstrap.min.css'

import { Header, NotFound } from './components'
import { ForgotPassword, Home, Login, SignUp } from './pages'
import LogoGuia from './assets/images/logo-guiabolso.svg'

import './assets/styles/routes.css'


import { isAuthenticated } from "./services/auth";

const PrivateRoute = ({ component: Component, ...rest }) => (
    <Route
        {...rest}
        render={props =>
            isAuthenticated() ? (
                <Component {...props} />
            ) : (
                    <Redirect to={{ pathname: "/", state: { from: props.location } }} />
                )
        }
    />
);

const options = {
    timeout: 4000,
    position: positions.BOTTOM_CENTER
};

function Routes() {
    return (
        <Provider template={AlertTemplate} {...options}>
            <BrowserRouter>
                <Header
                    classTitle="navbar navbar-light text-light bg-dark"
                    classImg="logo"
                    srcImg={LogoGuia}
                    altImg="logo do GuiaBolso"
                    title="Central de Erros"
                />
                <Switch>
                    <Route exact path='/' component={Login} />
                    <Route path="/login" component={Login} />
                    <Route path="/signUp" component={SignUp} />
                    <PrivateRoute path="/home" component={Home} />
                    <Route path="/forgotPassword" component={ForgotPassword} />
                    <Route path="*" component={NotFound} />
                </Switch>
            </BrowserRouter>
        </Provider>
    )
}

export default Routes
