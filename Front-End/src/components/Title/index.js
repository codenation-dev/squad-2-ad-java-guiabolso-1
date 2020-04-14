import React from 'react'

const Title = (props) => {
    return (
        <span className={props.classTitle}>
             <span>{props.title}</span>
             <img className={props.classImg} src={props.srcImg} alt={props.altImg} />
        </span>
    )
}

export default Title