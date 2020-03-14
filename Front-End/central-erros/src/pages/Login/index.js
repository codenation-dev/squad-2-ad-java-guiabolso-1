import React from "react";
import Form from '../../components/Form'
import Title from '../../components/Title'
import Link from '../../components/Link'

import './styles.css'

const Login = () => {

    return (
        <>
            <Title
                classTitlePage="navbar navbar-light text-light bg-dark"
                titlePage="Central de Erros" />
            <div className='containerLogin'>
                <Form
                    title='Login'
                    submit='Login'
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
        </>
    );

}

export default Login