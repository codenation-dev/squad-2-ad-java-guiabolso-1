import React from 'react'

const Select = props => {
    return (
        <select>
            <option selected value={props.selectedValue}>{props.selectedValue}</option>
            <option value={props.value}>{props.value}</option>
        </select>
    )
}

export default Select