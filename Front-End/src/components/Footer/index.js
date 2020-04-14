import React from 'react'

const Footer = (props) => {
    return (
        <span className={props.classFooter}>
             <img className={props.classImg} src={props.srcImg} alt={props.altImg} />
             <span>{props.title}</span>
        </span>
    )
}

export default Footer