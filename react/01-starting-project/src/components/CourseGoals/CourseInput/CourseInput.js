import React, { useState } from 'react';

import Button from '../../UI/Button/Button';
import './CourseInput.css';

const CourseInput = props => {
  let [enteredValue, setEnteredValue] = useState('');
  let [isValid,setIsValid] = useState(true);//we add this to check if have any value in input

  const goalInputChangeHandler = event => {
    if(enteredValue.trim().length > 0){//here we add check because if input is valid we do not need to color label
      setIsValid(true);
    }
    setEnteredValue(event.target.value);
  };

  const formSubmitHandler = event => {
    event.preventDefault();
    if(enteredValue.trim().length === 0){//here we add check
      setIsValid(false);
      return;
    }
    props.onAddGoal(enteredValue);//here we pass data to parent component
  };

  return (
    <form onSubmit={formSubmitHandler}>
      <div className={`form-control ${!isValid ? 'invalid' : ''}`}>
        <label>Course Goal</label>{/*here we add conditional color {{color:!isValid?'red':'black'}} if input isvalid,also we can add
        just a simple class with these colors but not to add inline this colors and we can use this classess to many places without repeating the
        all colors for example we can add invalid -> form-controll invalid and now we will add css stile for this class in css file 
        and will change the way we will add new dynamic style as {`form-controll ${!isValid ? 'invalid' : ''}`} here in the 
        curly braces we add `` in which we can add string class name but we can add dynamically after $ in {} plain javascript code 
        after first ${} we can add more ${} we can use !is walid&&'invalid' this boolean expression will return invalid if is value is true*/}
        <input type="text" onChange={goalInputChangeHandler} />
      </div>
      <Button type="submit">Add Goal</Button>
    </form>
  );
};

export default CourseInput;
