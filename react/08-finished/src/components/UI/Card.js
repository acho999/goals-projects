import React from 'react';
import Wrapper from '../Helpers/Wrapper';

import classes from './Card.module.css';

const Card = (props) => {
  return <Wrapper className={`${classes.card} ${props.className}`}>{props.children}</Wrapper>;
  {/*here we wrap other components or html in our wrapper component*/}
};

export default Card;
