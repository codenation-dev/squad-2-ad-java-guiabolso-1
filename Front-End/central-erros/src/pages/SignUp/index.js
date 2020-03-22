import React, { useState } from "react"
import { useAlert } from "react-alert"
import { useHistory } from "react-router-dom"
import { Link, FormSignUp } from '../../components'

import './styles.css'

const Signup = () => {
    const [name, setName] = useState(null)
    const [email, setEmail] = useState(null)
    const [password, setPassword] = useState(null)

    const alert = useAlert()
    let history = useHistory()

    const handleSubmit = (e) => {
        e.preventDefault()
        if (name && email && password) {
            alert.success("Cadastro efetuado com sucesso! Efetue o login!")
            history.push("/sign-in")
        } else {
            alert.show("Preencha todos os campos.")
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
                href="http://localhost:3000/sign-in"
            />


        </div>
    )
}
export default Signup