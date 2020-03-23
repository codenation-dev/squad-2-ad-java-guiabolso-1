import React from 'react'

const Header = (props) => {
    return(
        <span className={props.classTitle}>{props.title}</span>
    )
}

export default Header