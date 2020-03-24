import React, { useState } from "react"
import { useAlert } from "react-alert"
import { useHistory } from "react-router-dom"
import Form from '../../components/Form'
import Link from '../../components/Link'

import './styles.css'

const Login = () => {

    const [email, setEmail] = useState("")
    const [password, setPassword] = useState("")

    const alert = useAlert()
    let history = useHistory()

    const handleOnClick = (e) => {
        e.preventDefault()
        if (email && password){
            alert.success("Você está logado!")
            history.push("/home")
        } else {
            alert.show("Preencha todos os dados.")
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