import React from 'react'

const Content = props => {
    return (
        <span className={props.classContent}>{props.children}</span>
    )
}

export default Content