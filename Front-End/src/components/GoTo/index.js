import React from 'react'
import { Link } from 'react-router-dom'

const GoTo = (props) => {
    return(
        <span className={props.classLink}>{props.firstText}<Link to={props.path}>{props.secondText}</Link></span>
    )
}

export default GoTo