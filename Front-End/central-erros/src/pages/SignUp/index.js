import React, { useState } from "react"
import { useHistory } from "react-router-dom"
import FormSignUp from '../../components/FormSignUp'

import './styles.css'

const Signup = () => {
    const [name, setName] = useState(null)
    const [email, setEmail] = useState(null)
    const [password, setPassword] = useState(null)
    
    let history = useHistory()

    const sent = (e) => {
        e.preventDefault()
        if (name && email && password) {
            alert("Cadastro efetuado com sucesso! Efetue o login!")
            history.push("/sign-in")
        } else {
            alert("Preencha todos os campos.")
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
                onSubmit={(e) => { sent(e) }}
            />



        </div>
    )
}
export default Signup