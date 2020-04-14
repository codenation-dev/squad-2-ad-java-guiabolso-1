import React, { useState, useEffect } from "react"
import { useAlert } from "react-alert"
import { useHistory } from "react-router-dom"

import { logout } from "../../services/auth"
import { FormForgotPassword, GoTo } from "../../components"
import "./styles.css"

const ForgotPassword = () => {

    const [email, setEmail] = useState("")

    const alert = useAlert()
    let history = useHistory()

    useEffect(() => logout, []);

    const handleSubmit = (e) => {
        e.preventDefault()
        if (email) {
            alert.success("Senha enviada com sucesso! Confira sua caixa de entrada e efetue seu login!")
            history.push("/sign-in")
        } else {
            alert.show("Preencha seu e-mail")
        }
    }

    return (
        <div className="containerPassword">
            <FormForgotPassword
                classForm="m-4"
                onSubmit={(e) => handleSubmit(e)}
                title="Esqueceu a senha?"
                paragraph="Preencha seu e-mail que enviaremos a senha cadastrada para você"
                classContainerInput="form-group"
                typeInput="email"
                classInput="form-control"
                placeholder="E-mail"
                onChange={(e) => setEmail(e.target.value)}
                typeButton="submit"
                classButton="btn btn-primary btn-block"
                textButton="Enviar!"
            />

            <GoTo
                firstText="Voltar para "
                secondText="Login"
                path="/login"
            />
            <GoTo
                firstText="Não tem cadastro?"
                secondText=" Cadastre-se aqui!"
                path="/signUp"
            />
        </div>
    )
}
export default ForgotPassword