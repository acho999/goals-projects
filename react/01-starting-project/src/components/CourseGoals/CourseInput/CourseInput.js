import React, { useState } from 'react';

import Button from '../../UI/Button/Button';
import './CourseInput.css';

const CourseInput = props => {
  const [enteredValue, setEnteredValue] = useState('');
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
      <div className="form-control">
        <label style={{color:!isValid?'red':'black'}}>Course Goal</label>{/*here we add conditional color if input isvalid*/}
        <input style={{borderColor:!isValid?'red':'black',background:!isValid?'salmon':'transparent'}} type="text" onChange={goalInputChangeHandler} />
      </div>
      <Button type="submit">Add Goal</Button>
    </form>
  );
};

export default CourseInput;
