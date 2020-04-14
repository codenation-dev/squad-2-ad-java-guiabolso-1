import React, { useState, useEffect } from "react"
import { useAlert } from "react-alert"
import { useHistory } from "react-router-dom"

import api from "../../services/api"
import { login, logout, nameUser } from "../../services/auth"
import { Form, GoTo } from '../../components'

import logo from '../../assets/images/squad2.jpeg'
import "./styles.css"

const Login = () => {

    const [email, setEmail] = useState("")
    const [password, setPassword] = useState("")

    const alert = useAlert()
    let history = useHistory()

    useEffect(() => logout, []);

    const handleOnClick = async (e) => {
        e.preventDefault()
        if (!email || !password) {
            alert.show("Preencha e-mail e senha para continuar!")
        } else {
            try {
                const response = await api.post("/authenticate", { email, password })
                nameUser(response.data.authenticatedUserName)
                login(response.data.token)
                history.push("/home")
                alert.success("Você está logado!")
            } catch (error) {
                console.log(error)
                alert.error("Houve um problema com o login, verifique suas credenciais.")

            }
        }
    }

        return (
            <div className="containerLogin">
                <img 
                    className="logoSquad"
                    alt="logo do Squad 2"  
                    src={logo} />
                <Form
                    title="Login"
                    submit="Login"
                    onChangeEmail={(e) => setEmail(e.target.value)}
                    onChangePassword={(e) => setPassword(e.target.value)}
                    onSubmit={(e) => handleOnClick(e)}
                />

                <GoTo
                    firstText="Não tem cadastro? "
                    secondText="Cadastre-se aqui!"
                    path="/signUp"
                />

            </div>
        )
    }

export default Login