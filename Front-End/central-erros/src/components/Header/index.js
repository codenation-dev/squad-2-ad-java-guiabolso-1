import React from 'react'

const Header = (props) => {
    return(
        <span className={props.classTitlePage}>{props.titlePage}</span>
    )
}

export default Header