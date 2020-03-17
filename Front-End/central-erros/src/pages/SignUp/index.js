import React, { useState } from "react";
import FormSignUp from '../../components/FormSignUp'
import Title from '../../components/Header'
import Link from '../../components/Link'


const Signup =() =>{
    const [name , setName]=useState('')
    const[email, setEmail]=useState('')
    const [password, setPassword]=useState('')

    return(
        <div className ='containerLogin'>
            <FormSignUp
            title ='SignUp'
            submit='Signup'
            onChangeName = {(e) => setName(e.target.value)}
            onChangeEmail={(e) => setEmail(e.target.value)}
            onChangePassword={(e) => setPassword(e.target.value)}
            />

          

        </div>
    )
}
export default Signup