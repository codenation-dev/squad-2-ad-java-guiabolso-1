import React, { useState } from "react";
import Form from '../../components/Form'
import Title from '../../components/Header'

const ForgotPassword = () =>{

    const [email, setEmail] = useState('')
    const [password, setPassword] = useState('')
    return(
        <div className='containerLogin'>
            <Form
                title='Forgot Password'
                submit='Submit'
                onChangeEmail={(e) => setEmail(e.target.value)}
                onChangePassword={(e) => setPassword(e.target.value)}
                />
        </div>
    )
}
export default ForgotPassword