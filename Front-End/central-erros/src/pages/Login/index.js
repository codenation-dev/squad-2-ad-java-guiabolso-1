import React from "react";
import Form from '../../components/Form'
import Title from '../../components/Title'

import './styles.css'

const Login = () => {
    
    return (
        <div className='containerLogin'>
            <Title 
            classTitlePage="m-4"
            titlePage="Central de Erros" />
            <Form 
            title='Login'
            submit='Login'
             />
        </div>
    );

}

export default Login