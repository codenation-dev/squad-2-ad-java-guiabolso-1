import React, { useState } from "react";
import Form from '../../components/Form'
import Title from '../../components/Header'
import Link from '../../components/Link'

import './styles.css'

const Login = () => {

    const [email, setEmail] = useState('')
    const [password, setPassword] = useState('')


    return (
        <div className='containerLogin'>
            <Form
                title='Login'
                submit='Login'
                onChangeEmail={(e) => setEmail(e.target.value)}
                onChangePassword={(e) => setPassword(e.target.value)}

            />
            <Link
                firstText="Esqueceu a "
                secondText="senha?"
                href="http://localhost:3000/forgot-password"
            />
            <Link
                secondText="Cadastre-se!"
                href="http://localhost:3000/sign-up"
            />

        </div>
    )
}

export default Login