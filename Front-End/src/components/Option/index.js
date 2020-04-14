import React from "react"

const Option = (props) => {

    const { list } = props

    return (
        list.map(l => (
            <option
                key={l.value}
                value={l.value}>
                {l.label}
            </option>
        ))
    )

}
export default Option
