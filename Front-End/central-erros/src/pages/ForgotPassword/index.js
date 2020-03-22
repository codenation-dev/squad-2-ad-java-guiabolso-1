import React, { useState } from "react"
import { useAlert } from "react-alert"
import { useHistory } from "react-router-dom"
import { FormForgotPassword, Link } from "../../components"
import "./styles.css"

const ForgotPassword = () => {

    const [email, setEmail] = useState(null)

    const alert = useAlert()
    let history = useHistory()

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
        <div className='containerPassword'>
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
            <Link
                firstText="Voltar para "
                secondText="Login"
                href="http://localhost:3000/sign-in"
            />
            <Link
                firstText="Não tem cadastro?"
                secondText=" Cadastre-se aqui!"
                href="http://localhost:3000/sign-up"
            />
        </div>
    )
}
export default ForgotPassword