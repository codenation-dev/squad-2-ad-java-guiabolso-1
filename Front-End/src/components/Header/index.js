import React from 'react'

const Header = (props) => {
    return (
        <span className={props.classTitle}>
             <img className={props.classImg} src={props.srcImg} alt={props.altImg} />
             <span>{props.title}</span>
        </span>
    )
}

export default Header