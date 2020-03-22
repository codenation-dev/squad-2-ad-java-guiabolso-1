import React, { useState } from 'react'
import { Header } from '../../components'

import './styles.css'

const Home = () => {

    const [tipo, setTipo] = useState(null)
    const [ordenarPor, setOrdenarPor] = useState(null)
    const [buscarPor, setBuscarPor] = useState(null)
    /* 
        const tipos = ['Produção', 'Homologação', 'Dev']
        const ordenacao = ['Level', 'Frequência']
        const busca = ['Level', 'Descrição', 'Origem']
     */

    return (
        <>
            <Header classTitle="navbar navbar-light text-dark bg-light"
                title="Seja bem vindo usuário. Seu token é: kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk" />
            <form className="formStyle">
                <select className="select" value={tipo} onChange={() => { setTipo() }}>
                    <option value="Produção">{"Produção"}</option>
                    <option value="Homologação">{"Homologação"}</option>
                    <option value="Dev">{"Dev"}</option>
                </select>
                <select className="select" value={ordenarPor} onChange={() => { setOrdenarPor() }}>
                    <option value="Level">{"Level"}</option>
                    <option value="Frequência">{"Frequência"}</option>
                </select>
                <select className="select" value={buscarPor} onChange={() => { setBuscarPor() }}>
                    <option value="Level">{"Level"}</option>
                    <option value="Descrição">{"Descrição"}</option>
                    <option value="Origem">{"Origem"}</option>
                </select>
                <input className="input">
                </input>
                <button>Buscar!</button>
            </form>
            
        </>
    )
}

export default Home