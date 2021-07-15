import React from 'react';

import Navigation from './Navigation';
import classes from './MainHeader.module.css';

const MainHeader = (props) => {
  return (
    <header className={classes['main-header']}>
      <h1>A Typical Page</h1>
      {/*<Navigation isLoggedIn={props.isAuthenticated} onLogout={props.onLogout} />*/}
      <Navigation/>{/*here we remove some attributes in order to use context in navigation component*/}
    </header>
  );
};

export default MainHeader;
