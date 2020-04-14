import React from 'react'

const Form = (props) => {


    return (
        <form className="m-4" onSubmit={props.onSubmit}>
            <h3>{props.title}</h3>
            <div className="form-group">
                <label>Preencha seu e-mail: </label>
                <input type="email" className="form-control" placeholder="e-mail" onChange={props.onChangeEmail}
                />
            </div>
            <div className="form-group">
                <label>Preencha sua senha:</label>
                <input type="password" className="form-control" placeholder="senha"
                    onChange={props.onChangePassword} />
            </div>
            <button type="submit" className="btn btn-primary btn-block">{props.submit}</button>
        </form>
    )
}

export default Form