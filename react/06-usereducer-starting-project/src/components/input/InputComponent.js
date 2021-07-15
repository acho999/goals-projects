import React from 'react';

const Input = (props)=>{

    return(
        <div
          className={`${classes.control} ${
            props.isValid === false ? classes.invalid : ''
          }`}
        >
          <label htmlFor={props.id}>{props.label}</label>
          {/*below we make two way binding with value={emailState.value} */}
          <input
            type={props.type}
            id={props.id}
            value={props.value} 
            onChange={props.onChange}
            onBlur={props.onBlur}
          />
        </div>

    )

}