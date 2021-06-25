import React, { useState,useEffect } from 'react';

import Card from '../UI/Card/Card';
import classes from './Login.module.css';
import Button from '../UI/Button/Button';

const Login = (props) => {
  const [enteredEmail, setEnteredEmail] = useState('');
  const [emailIsValid, setEmailIsValid] = useState();
  const [enteredPassword, setEnteredPassword] = useState('');
  const [passwordIsValid, setPasswordIsValid] = useState();
  const [formIsValid, setFormIsValid] = useState(false);

  useEffect(() =>{//this useEffect will be triggered when component is rendered and will be executed once
    //but when we want to rerender after some changes and in order for they to be visible we have to pass 
    //parameters in array argument.
    let identifier = setTimeout(() =>{
      setFormIsValid(
        enteredEmail.includes('@') && enteredPassword.trim().length > 6
      );
    },500)//this function inside will be executed after 500 milliseconds
    
      return () =>{ clearTimeout(identifier);} //if we put this here that will clear all subscriptions to any event this just 
      //clear up setInterval function for example when component is unmounting
  },[setFormIsValid,enteredEmail,enteredPassword])//here we pass the parameters or dependencies which if have been changed
  //useEffect will be executed only then we can remove setFormIsValid because it is function that changes formIsValid variable and
  //this function do not change it self and that is why we can omitt them

  const emailChangeHandler = (event) => {
    setEnteredEmail(event.target.value);

   
  };

  const passwordChangeHandler = (event) => {
    setEnteredPassword(event.target.value);

    setFormIsValid(
      event.target.value.trim().length > 6 && enteredEmail.includes('@')
    );
  };

  const validateEmailHandler = () => {
    setEmailIsValid(enteredEmail.includes('@'));
  };

  const validatePasswordHandler = () => {
    setPasswordIsValid(enteredPassword.trim().length > 6);
  };

  const submitHandler = (event) => {
    event.preventDefault();
    props.onLogin(enteredEmail, enteredPassword);
  };

  return (
    <Card className={classes.login}>
      <form onSubmit={submitHandler}>
        <div
          className={`${classes.control} ${
            emailIsValid === false ? classes.invalid : ''
          }`}
        >
          <label htmlFor="email">E-Mail</label>
          <input
            type="email"
            id="email"
            value={enteredEmail}
            onChange={emailChangeHandler}
            onBlur={validateEmailHandler}
          />
        </div>
        <div
          className={`${classes.control} ${
            passwordIsValid === false ? classes.invalid : ''
          }`}
        >
          <label htmlFor="password">Password</label>
          <input
            type="password"
            id="password"
            value={enteredPassword}
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
