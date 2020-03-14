import React from 'react'

const Button = props => {
    return (
        <button className={props.classButton} onClick={props.onClick} />
    )
}

export default Button