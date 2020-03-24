import React, { useState } from "react"
import { useAlert } from "react-alert"
import { useHistory } from "react-router-dom"

import api from "../../services/api";
import { login } from "../../services/auth";
import Form from '../../components/Form'
import Link from '../../components/Link'

import './styles.css'

const Login = () => {

    const [email, setEmail] = useState("")
    const [password, setPassword] = useState("")

    const alert = useAlert()
    let history = useHistory()

    const handleOnClick = async (e) => {
        e.preventDefault()
        if (!email || !password) {
            alert.show("Preencha e-mail e senha para continuar!")
        } else {
            try {
                const response = await api.post("/users", { email, password })
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
            <div className='containerLogin'>
                <Form
                    title='Login'
                    submit='Login'
                    onChangeEmail={(e) => setEmail(e.target.value)}
                    onChangePassword={(e) => setPassword(e.target.value)}
                    onSubmit={(e) => handleOnClick(e)}
                />
                <Link
                    firstText="Esqueceu a senha? "
                    secondText="Clique aqui!"
                    href="http://localhost:3000/forgotPassword"
                />
                <Link
                    secondText="Cadastre-se!"
                    href="http://localhost:3000/signUp"
                />

            </div>
        )
    }

export default Login