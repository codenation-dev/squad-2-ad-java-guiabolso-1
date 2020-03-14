import React, { useState } from 'react'

const Form = (props) => {

    
    return (
        <form className="m-4" onSubmit={props.onSubmit}>
            <h3>{props.title}</h3>
            <div className="form-group">
                <label>Email address</label>
                <input type="email" className="form-control" placeholder="e-mail" />
            </div>
            <div className="form-group">
                <label>Password</label>
                <input type="password" className="form-control" placeholder="password" />
            </div>
            <button type="submit" className="btn btn-primary btn-block">{props.submit}</button>
        </form>
    )
}

export default Form