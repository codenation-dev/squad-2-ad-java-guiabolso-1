import React, { useState, useEffect } from "react"
import { useAlert } from "react-alert"
import { useHistory } from "react-router-dom"

import { logout } from "../../services/auth"
import { GoTo, FormSignUp } from "../../components"
import api from "../../services/api"

import logo from "../../assets/images/squad2.jpeg"

import "./styles.css"

const Signup = () => {
    const [name, setName] = useState("")
    const [email, setEmail] = useState("")
    const [password, setPassword] = useState("")

    const alert = useAlert()
    let history = useHistory()

    useEffect(() => logout, []);

    const handleSubmit = async (e) => {
        e.preventDefault()
        if (!name || !email || !password) {
            alert.show("Preencha todos os campos.")
        } else {
            try {
                await api.post("/user/registration", { name, email, password })
                history.push("/login")
                alert.success("Cadastro efetuado com sucesso! Efetue o login!")

            } catch (error) {
                console.log(error)
                alert.error("Ocorreu um erro ao registrar sua conta. Tente novamente.")
            }
        }
    }

    return (
        <div className="containerSignUp">
            <img
                className="logoSquad"
                alt="logo do Squad 2"
                src={logo} />
            <FormSignUp
                title="Cadastro"
                submit="Enviar!"
                onChangeName={(e) => setName(e.target.value)}
                onChangeEmail={(e) => setEmail(e.target.value)}
                onChangePassword={(e) => setPassword(e.target.value)}
                onSubmit={(e) => { handleSubmit(e) }}
            />

            <GoTo
                firstText="Já tem cadastro? Faça o seu login"
                secondText=" aqui!"
                path="/login"
            />


        </div>
    )
}
export default Signup