import React, { useState, useEffect, useReducer } from 'react';

import Card from '../UI/Card/Card';
import classes from './Login.module.css';
import Button from '../UI/Button/Button';
import { act } from 'react-dom/cjs/react-dom-test-utils.production.min';

const emailReducer = (prevState, actionFunction)=>{
  if(actionFunction.type === 'USER_INPUT'){//here we check type from finction argument which we passed to dispatchEmail function
    return {value : actionFunction.value, isValid : actionFunction.value.includes('@')}
  }
  if(actionFunction.type === 'INPUT_BLUR'){
    return {value : prevState.value, isValid : prevState.value.includes('@')}//here we are using prevState to access last that is written from user
  }
  return {value:'',isValid:false}
};//here when we use useReducer function we can declare function which will be parameter outside component

const passwordReducer = (prevState, actionFunction)=>{
  if(actionFunction.type === 'USER_INPUT'){//here we check type from finction argument which we passed to dispatchPassword function
    return {value : actionFunction.value, isValid : actionFunction.value.trim().length > 6}
  }
  if(actionFunction.type === 'INPUT_BLUR'){
    return {value : prevState.value, isValid : prevState.value.trim().length > 6}//here we are using prevState to access last that is written from user
  }
  return {value:'',isValid:false}
};//here when we use useReducer function we can declare function which will be parameter outside component

const Login = (props) => {
 // const [enteredEmail, setEnteredEmail] = useState('');
 // const [emailIsValid, setEmailIsValid] = useState();
 //const [enteredPassword, setEnteredPassword] = useState('');
 // const [passwordIsValid, setPasswordIsValid] = useState();
  const [formIsValid, setFormIsValid] = useState(false);

  const[emailState, dispatchEmail] = useReducer(emailReducer,
    {value:'',isValid:false});// we use useReducer when we need to manage state which depends 
  //to other states or to manage complex state

  const [passwordState, dispatchPassword] = useReducer(passwordReducer, {value:'',isValid:false});

  useEffect(() => {
    console.log('EFFECT RUNNING');

    return () => {
      console.log('EFFECT CLEANUP');
    };
  }, []);

  const {isValid : isValidEmail} = emailState;//here with destructoring and adding aliases we extract isValit check to two variables
  const {isValid : isValidPassword} = passwordState//and we will use them below

  useEffect(() => {
    const identifier = setTimeout(() => {
      console.log('Checking form validity!');
      setFormIsValid(
        //enteredEmail.includes('@') && enteredPassword.trim().length > 6
        emailState.isValid && passwordState.isValid//here we add check from reducer
      );
    }, 500);

    return () => {
      console.log('CLEANUP');
      clearTimeout(identifier);
    };
  }, [isValidEmail,isValidPassword])//[emailState, passwordState]);//here we add states as dependencies because of following changes 
  //this useEffect will be executed every time when there is a change in emailState or passwordState
  //but this will cause many calls and to avoid that we will use state of inputs not a values

  const emailChangeHandler = (event) => {
    //setEnteredEmail(event.target.value);
    dispatchEmail({type:'USER_INPUT', value: event.target.value});//here we use dispatchEmail function to set emailstate

    // setFormIsValid(
    //   event.target.value.includes('@') && passwordState.isValid//here we use passwordState from reducer
    // );
  };

  const passwordChangeHandler = (event) => {
    //setEnteredPassword(event.target.value);
    dispatchPassword({type:'USER_INPUT',value:event.target.value});

    // setFormIsValid(
    //   emailState.isValid && event.target.value.trim().length > 6//here we use emailState.isValid from reducer
    // );
  };

  const validateEmailHandler = () => {
    //setEmailIsValid(emailState.isValid);//here we take isValid from reducer
    dispatchEmail({type:'INPUT_BLUR'});//here we  add only type bacause we need to know only that input have lost  a focus
  };

  const validatePasswordHandler = () => {
    //setPasswordIsValid(passwordState.isValid);
    dispatchPassword({type:'INPUT_BLUR'})
  };

  const submitHandler = (event) => {
    event.preventDefault();
    props.onLogin(emailState.value, passwordState.value);//here we take emailState from reducer
  };

  return (
    <Card className={classes.login}>
      <form onSubmit={submitHandler}>
        <div
          className={`${classes.control} ${
            emailState.isValid === false ? classes.invalid : ''
          }`}
        >
          <label htmlFor="email">E-Mail</label>
          {/*below we make two way binding with value={emailState.value} */}
          <input
            type="email"
            id="email"
            value={emailState.value} 
            onChange={emailChangeHandler}
            onBlur={validateEmailHandler}
          />
        </div>
        <div
          className={`${classes.control} ${
            //passwordIsValid === false ? classes.invalid : ''
            passwordState.isValid === false ? classes.invalid : ''
          }`}
        >
          <label htmlFor="password">Password</label>
          <input
            type="password"
            id="password"
            value={passwordState.value}
            onChange={passwordChangeHandler}
            onBlur={validatePasswordHandler}
          />
        </div>
        <div className={classes.actions}>
          <Button type="submit" className={classes.btn} disabled={!formIsValid}>
            Login
          </Button>
        </div>
      </form>
    </Card>
  );
};

export default Login;
