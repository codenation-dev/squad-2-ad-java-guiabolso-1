import React, { useState, useEffect } from "react"
import { useAlert } from "react-alert"
import { Option, Row, Title } from "../../components"
import api from "../../services/api"
import { getName, getToken } from "../../services/auth"
import { tipos, ordenacao, busca } from "./data"


import logoUser from "../../assets/images/user.png"

import "./styles.css"

const Home = () => {

    const [user] = useState(getName())
    const [token] = useState(getToken())
    const [tokenSmall] = useState(token.slice(0, 20))
    const [title] = useState(`Bem vinde ${user}. Seu token é: ${tokenSmall}`)
    const [tipo, setTipo] = useState("")
    const [ordenarPor, setOrdenarPor] = useState("")
    const [buscarPor, setBuscarPor] = useState("")
    const [input, setInput] = useState("")
    const [table, setTable] = useState([])
    const [found, setFound] = useState([])

    const alert = useAlert()

    useEffect(() => {
        async function fetchData() {
            try {
                const config = {
                    headers: { Authorization: `Bearer ${token}` }
                };
                const response = await api.get("/log/list", config)
                setTable(response.data)
                setFound(response.data)
            } catch (error) {
                console.log(error)
            }
        }
        fetchData()

    }, [token])


    useEffect(() => {
        const data = table.filter(param => {
            return param.environment === tipo
        })

        if (tipo === "") {
            setFound(table)
        } else {
            setFound(data)
        }

    }, [tipo]);



    useEffect(() => {

        if (ordenarPor === "") {
            setFound(table)
        } else if (ordenarPor === "level") {
            const data = found.sort((function (a, b) {
                return (a.level > b.level) ? 1 : ((b.level > a.level) ? -1 : 0)
            }
            ))
            setFound(data)
        }

    }, [ordenarPor]);


    const handleSubmit = (e) => {
        e.preventDefault()

        if (buscarPor === "level") {
            const data = table.filter(param => {
                return param.level === input.toUpperCase()
            })
            setFound(data)

        } else if (buscarPor === "descricao") {
            const data = table.filter(param => {
                return param.eventDescription.toUpperCase() === input.toUpperCase()
            })
            setFound(data)

        } else if (buscarPor === "") {
            setFound(table)
        } else {
            alert.error("Não encontrado.")
        }
    }


    return (
        <>
            <Title classTitle="title"
                title={title}
                classImg="img"
                srcImg={logoUser}
                altImg="logo de usuario genérico" />

            <form className="formStyle" onSubmit={(e) => handleSubmit(e)} >
                <select id="tipos"
                    className="select"
                    value={tipo}
                    onChange={
                        (e) => { setTipo(e.target.value) }} >
                    <Option list={tipos} />
                    ))
                    }
                </select>
                <select className="select"
                    value={ordenarPor}
                    onChange={
                        (e) => { setOrdenarPor(e.target.value) }} >
                    <Option list={ordenacao} />
                </select>
                <select className="select"
                    value={buscarPor}
                    onChange={
                        (e) => { setBuscarPor(e.target.value) }} >
                    <Option list={busca} />
                </select>
                <input className="input"
                    value={input}
                    onChange={
                        (e) => { setInput(e.target.value) }} >
                </input>
                <button> Buscar! </button>
            </form>
            <table className="table table-striped text-center" >
                <thead >
                    <tr >
                        <th> Level </th>
                        <th> Log </th>
                        <th> Eventos </th>
                    </tr>
                </thead>
                <tbody >
                    <Row list={found} />
                </tbody>
            </table>
        </>
    )
}

export default Home