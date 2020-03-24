import React, { useState } from "react"
import { useAlert } from "react-alert"
import { useHistory } from "react-router-dom"

import { Link, FormSignUp } from "../../components"
import api from "../../services/api"

import "./styles.css"

const Signup = () => {
    const [name, setName] = useState("")
    const [email, setEmail] = useState("")
    const [password, setPassword] = useState("")

    const alert = useAlert()
    let history = useHistory()

    const handleSubmit = async (e) => {
        e.preventDefault()
        if (!name || !email || !password) {
            alert.show("Preencha todos os campos.")
        } else {
            try {
                await api.post("/users", {name, email, password})
                history.push("/sign-in")
                alert.success("Cadastro efetuado com sucesso! Efetue o login!")
            } catch(error) {
                console.log(error)
                alert.error("Ocorreu um erro ao registrar sua conta. Tente novamente.")
            }
        }
    }

    return (
        <div className='containerSignUp'>
            <FormSignUp
                title='Cadastro'
                submit='Enviar!'
                onChangeName={(e) => setName(e.target.value)}
                onChangeEmail={(e) => setEmail(e.target.value)}
                onChangePassword={(e) => setPassword(e.target.value)}
                onSubmit={(e) => { handleSubmit(e) }}
            />

            <Link
                firstText="Já tem cadastro? Faça o seu login"
                secondText=" aqui!"
                href="http://localhost:3000/login"
            />


        </div>
    )
}
export default Signup