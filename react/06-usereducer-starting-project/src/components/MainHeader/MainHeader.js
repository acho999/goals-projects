import React from 'react';

import Navigation from './Navigation';
import classes from './MainHeader.module.css';

const MainHeader = (props) => {
  return (
    <header className={classes['main-header']}>
      <h1>A Typical Page</h1>
      {/*<Navigation isLoggedIn={props.isAuthenticated} onLogout={props.onLogout} />*/}
      <Navigation onLogout={props.onLogout} />{/*here we remove some attributes in order to use context*/}
    </header>
  );
};

export default MainHeader;
