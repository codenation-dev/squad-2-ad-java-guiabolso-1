import React from "react"

const Row = (props) => {

    const { list } = props

    return (
        list.map(l => (
                <tr key={l.id}>
                    <td>{l.level}</td>
                    <td>{l.environment}</td>
                    <td>{l.eventDescription}</td>
                </tr>
        ))
    )

}
export default Row
