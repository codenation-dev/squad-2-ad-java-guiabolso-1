import React, { useState } from "react";
import FormSignUp from '../../components/FormSignUp'

import './styles.css'
    
const Signup =() =>{
    const [name , setName]=useState('')
    const[email, setEmail]=useState('')
    const [password, setPassword]=useState('')

    return(
        <div className ='containerSignUp'>
            <FormSignUp
            title ='Cadastro'
            submit='Enviar!'
            onChangeName = {(e) => setName(e.target.value)}
            onChangeEmail={(e) => setEmail(e.target.value)}
            onChangePassword={(e) => setPassword(e.target.value)}
            />

          

        </div>
    )
}
export default Signup