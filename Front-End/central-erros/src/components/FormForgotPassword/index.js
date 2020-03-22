import React from "react"

const FormForgotPassword = (props) => {
    return (
        <form className={props.classForm} onSubmit={props.onSubmit}>
            <h3>{props.title}</h3>
            <p>{props.paragraph}</p>
            <div className={props.classContainerInput}>
                <input type={props.typeInput} className={props.classInput} placeholder={props.placeholder} onChange={props.onChange}
                />
            </div>
            <button type={props.typeButton} className={props.classButton}>{props.textButton}</button>
        </form>
    )
}

export default FormForgotPassword