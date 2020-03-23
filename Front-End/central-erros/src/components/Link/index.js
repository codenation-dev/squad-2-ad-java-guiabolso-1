import React from 'react'

const Link = (props) => {
    return(
        <span className={props.classLink}>{props.firstText}<a href={props.href}>{props.secondText}</a></span>
    )
}

export default Link