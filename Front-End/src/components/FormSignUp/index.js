import React from 'react'

const FormSignUp =(props)=>{
    return(
        <form className="m-4" onSubmit={props.onSubmit}>
        <h3>{props.title}</h3>
        <div className="form-group">
            <label>Seu nome completo:</label>
            <input type="text" className="form-control" placeholder="nome" onChange={props.onChangeName}
            />
        </div>
        <div className="form-group">
                <label>Seu e-mail:</label>
                <input type="email" className="form-control" placeholder="e-mail" onChange={props.onChangeEmail}
                />
            </div>
        
        <div className="form-group">
            <label>Escolha uma senha:</label>
            <input type="password" className="form-control" placeholder="senha"
            onChange={props.onChangePassword} />
        </div>
        <button type="submit" className="btn btn-primary btn-block">{props.submit}</button>
    </form>
    )
}
export default FormSignUp